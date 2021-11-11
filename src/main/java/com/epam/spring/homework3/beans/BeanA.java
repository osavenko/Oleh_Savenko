package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements MyBean, InitializingBean, DisposableBean {
    private String name;
    private int value;

    public BeanA() {
    }

    public BeanA(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - afterPropertiesSet()");
    }
}
