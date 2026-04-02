package com.E_commerce.MultiGenesys;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.Ecommerce.Entity.CartItem;
import com.example.Ecommerce.Entity.Product;
import com.example.Ecommerce.Entity.User;
import com.example.Ecommerce.Repository.CartItemRepository;
import com.example.Ecommerce.Repository.ProductRepository;
import com.example.Ecommerce.Repository.UserRepository;
import com.example.Ecommerce.Service.CartService;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private ProductRepository productRepository;

	@Mock
	private CartItemRepository cartItemRepository;

	@InjectMocks
	private CartService cartService;

	@Test
	public void testAddToCart_Success() {

		User mockUser = new User();
		mockUser.setId(1L);
		mockUser.setEmail("test@gmail.com");
		Product mockProduct = new Product();
		mockProduct.setId(10L);
		mockProduct.setName("Test Product");
		mockProduct.setPrice(500.0);
		CartItem mockCartItem = new CartItem();
		mockCartItem.setUser(mockUser);
		mockCartItem.setProduct(mockProduct);
		mockCartItem.setQuantity(2);
		when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));
		when(productRepository.findById(10L)).thenReturn(Optional.of(mockProduct));
		when(cartItemRepository.save(any(CartItem.class))).thenReturn(mockCartItem);
		CartItem savedItem = cartService.addToCart(1L, 10L, 2);
		assertNotNull(savedItem);
		assertEquals(2, savedItem.getQuantity());
		assertEquals("Test Product", savedItem.getProduct().getName());
		verify(cartItemRepository, times(1)).save(any(CartItem.class));
	}
}