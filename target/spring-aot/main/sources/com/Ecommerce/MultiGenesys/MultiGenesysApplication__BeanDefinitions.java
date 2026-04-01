package com.Ecommerce.MultiGenesys;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Bean definitions for {@link MultiGenesysApplication}.
 */
@Generated
public class MultiGenesysApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'multiGenesysApplication'.
   */
  public static BeanDefinition getMultiGenesysApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MultiGenesysApplication.class);
    beanDefinition.setTargetType(MultiGenesysApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(MultiGenesysApplication.class);
    beanDefinition.setInstanceSupplier(MultiGenesysApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'passwordEncoder'.
   */
  private static BeanInstanceSupplier<BCryptPasswordEncoder> getPasswordEncoderInstanceSupplier() {
    return BeanInstanceSupplier.<BCryptPasswordEncoder>forFactoryMethod(MultiGenesysApplication$$SpringCGLIB$$0.class, "passwordEncoder")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("multiGenesysApplication", MultiGenesysApplication.class).passwordEncoder());
  }

  /**
   * Get the bean definition for 'passwordEncoder'.
   */
  public static BeanDefinition getPasswordEncoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BCryptPasswordEncoder.class);
    beanDefinition.setFactoryBeanName("multiGenesysApplication");
    beanDefinition.setInstanceSupplier(getPasswordEncoderInstanceSupplier());
    return beanDefinition;
  }
}
