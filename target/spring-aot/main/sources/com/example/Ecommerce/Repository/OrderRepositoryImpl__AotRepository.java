package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Entity.Order;
import com.example.Ecommerce.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link OrderRepository}.
 */
@Generated
public class OrderRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public OrderRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link OrderRepository#findByUser(com.example.Ecommerce.Entity.User)}.
   */
  public List<Order> findByUser(User user) {
    String queryString = "SELECT o FROM Order o WHERE o.user = :user";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("user", user);

    return (List<Order>) query.getResultList();
  }
}
