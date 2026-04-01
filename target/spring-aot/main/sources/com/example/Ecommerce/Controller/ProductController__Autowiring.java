package com.example.Ecommerce.Controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ProductController}.
 */
@Generated
public class ProductController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProductController apply(RegisteredBean registeredBean, ProductController instance) {
    AutowiredFieldValueResolver.forRequiredField("productService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
