package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Entity.Order;
import com.example.Ecommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByUser(User user);
}
