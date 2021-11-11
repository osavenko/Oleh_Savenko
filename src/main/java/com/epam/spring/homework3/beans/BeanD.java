package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD implements MyBean {

    @Value("${beanD.name}")
    private String name;

    @Value("${beanD.value}")
    private int value;

    public BeanD() {
    }

    public BeanD(String name, int value) {
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
        return "BeanD{" +
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
