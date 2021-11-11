package com.epam.spring.homework3.configs;

import com.epam.spring.homework3.beans.BeanF;
import com.epam.spring.homework3.beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class LazyConfig {
    @Bean
    @Lazy
    public MyBean beanF() {
        return new BeanF();
    }
}
