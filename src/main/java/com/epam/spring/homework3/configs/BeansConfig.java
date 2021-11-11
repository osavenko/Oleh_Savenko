package com.epam.spring.homework3.configs;

import com.epam.spring.homework3.beans.*;
import org.springframework.context.annotation.*;

@Configuration
@Import(LazyConfig.class)
@PropertySource("classpath:application.properties")
@ComponentScan("com.epam.spring.homework3.beans")
public class BeansConfig {

    @Bean
    public MyBean beanA() {
        return new BeanA();
    }

    @Bean(
            initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod"
    )
    @DependsOn("beanD")
    public MyBean beanB() {
        return new BeanB();
    }


    @Bean(
            initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod"
    )
    @DependsOn("beanB")
    public MyBean beanC() {
        return new BeanC();
    }

    @Bean(
            initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod"
    )
    public MyBean beanD() {
        return new BeanD();
    }

    public MyBean beanE() {
        return new BeanE();
    }
}

