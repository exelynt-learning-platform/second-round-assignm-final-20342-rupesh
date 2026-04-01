package com.example.Ecommerce.Service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ProductService}.
 */
@Generated
public class ProductService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProductService apply(RegisteredBean registeredBean, ProductService instance) {
    AutowiredFieldValueResolver.forRequiredField("productRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
