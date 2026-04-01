package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Entity.CartItem;
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
 * AOT generated JPA repository implementation for {@link CartItemRepository}.
 */
@Generated
public class CartItemRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public CartItemRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link CartItemRepository#deleteByUser(com.example.Ecommerce.Entity.User)}.
   */
  public void deleteByUser(User user) {
    String queryString = "SELECT c FROM CartItem c WHERE c.user = :user";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("user", user);

    List resultList = query.getResultList();
    resultList.forEach(entityManager::remove);
    return;
  }

  /**
   * AOT generated implementation of {@link CartItemRepository#findByUser(com.example.Ecommerce.Entity.User)}.
   */
  public List<CartItem> findByUser(User user) {
    String queryString = "SELECT c FROM CartItem c WHERE c.user = :user";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("user", user);

    return (List<CartItem>) query.getResultList();
  }
}
