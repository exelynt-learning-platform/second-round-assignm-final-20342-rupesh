package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Entity.CartItem;
import com.example.Ecommerce.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // POST: /api/cart/add
    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody Map<String, Integer> request) {
        Long userId = Long.valueOf(request.get("userId"));
        Long productId = Long.valueOf(request.get("productId"));
        int quantity = request.get("quantity");

        CartItem savedItem = cartService.addToCart(userId, productId, quantity);
        return ResponseEntity.ok(savedItem);
    }

    // GET: /api/cart/{userId}
    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long userId) {
        List<CartItem> items = cartService.getCartItemsByUser(userId);
        return ResponseEntity.ok(items);
    }

    // DELETE: /api/cart/remove/{cartItemId}
    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<?> removeCartItem(@PathVariable Long cartItemId) {
        cartService.removeCartItem(cartItemId);
        return ResponseEntity.ok("Item removed from cart successfully!");
    }

    // DELETE: /api/cart/clear/{userId}
    @DeleteMapping("/clear/{userId}")
    public ResponseEntity<?> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart cleared successfully!");
    }
}