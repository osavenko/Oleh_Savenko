package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanC implements MyBean {

    @Value("${beanC.name}")
    private String name;

    @Value("${beanC.value}")
    private int value;

    public BeanC() {
    }

    public BeanC(String name, int value) {
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
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void customInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " - customInitMethod()");
    }

    public void customDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " - customDestroyMethod()");
    }
}
