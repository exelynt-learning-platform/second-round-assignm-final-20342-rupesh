package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Entity.CartItem;
import com.example.Ecommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	List<CartItem> findByUser(User user);

	void deleteByUser(User user);
}
