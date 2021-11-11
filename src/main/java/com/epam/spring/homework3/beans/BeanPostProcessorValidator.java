package com.epam.spring.homework3.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorValidator implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object myBean = bean;
        if (myBean instanceof MyBean) {
            if (((MyBean) bean).getName() != null && ((MyBean) bean).getValue() > 0) {
                System.out.println(beanName + " - valid!");
            } else {
                System.out.println(beanName + " - not valid!");
            }
        }
        return bean;
    }
}
