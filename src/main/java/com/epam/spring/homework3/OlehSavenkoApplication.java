package com.epam.spring.homework3;

import com.epam.spring.homework3.configs.BeansConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OlehSavenkoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String bean : beanDefinitionNames) {
            System.out.println(context.getBean(bean));
        }

        context.close();
    }
}
