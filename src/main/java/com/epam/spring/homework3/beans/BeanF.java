package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanF implements MyBean {

    private String name;
    private int value;

    public BeanF() {
    }

    public BeanF(String name, int value) {
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
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
