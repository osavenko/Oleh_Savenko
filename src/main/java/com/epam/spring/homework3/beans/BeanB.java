package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements MyBean {

    @Value("${beanB.name}")
    private String name;

    @Value("${beanB.value}")
    private int value;

    public BeanB() {
    }

    public BeanB(String name, int value) {
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
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void customInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " - customInitMethod()");
    }

    public void newInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " - newInitMethod()");
    }

    public void customDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " - customDestroyMethod()");
    }
}
