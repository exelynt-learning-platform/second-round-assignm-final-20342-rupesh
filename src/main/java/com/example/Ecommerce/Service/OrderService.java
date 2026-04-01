package com.example.Ecommerce.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Ecommerce.Entity.CartItem;
import com.example.Ecommerce.Entity.Order;
import com.example.Ecommerce.Entity.OrderItem;
import com.example.Ecommerce.Entity.User;
import com.example.Ecommerce.Repository.CartItemRepository;
import com.example.Ecommerce.Repository.OrderItemRepository;
import com.example.Ecommerce.Repository.OrderRepository;
import com.example.Ecommerce.Repository.UserRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartService cartService;

    // ऑर्डर प्लेस करण्याचे मुख्य लॉजिक
    @Transactional
    public Order placeOrder(Long userId, String shippingAddress, String paymentStatus) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        List<CartItem> cartItems = cartItemRepository.findByUser(user);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty! Cannot place order.");
        }
        double totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }
        Order order = new Order();
        order.setUser(user);
        order.setShippingAddress(shippingAddress);
        order.setPaymentStatus(paymentStatus);
        order.setTotalPrice(totalPrice);
        order = orderRepository.save(order);
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cItem : cartItems) {
            OrderItem oItem = new OrderItem();
            oItem.setOrder(order);
            oItem.setProduct(cItem.getProduct());
            oItem.setQuantity(cItem.getQuantity());
            oItem.setPrice(cItem.getProduct().getPrice()); 
            orderItems.add(oItem);
        }
        orderItemRepository.saveAll(orderItems);


        cartService.clearCart(userId);

        return order;
    }
    public List<Order> getUserOrders(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        return orderRepository.findByUser(user); // Repository मध्ये findByUser असायला हवे
    }
    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found!"));
        order.setPaymentStatus(status);
        return orderRepository.save(order);
    }
}