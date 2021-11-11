package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE implements MyBean {
    private String name;
    private int value;

    public BeanE() {
    }

    public BeanE(String name, int value) {
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
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @PostConstruct
    public void postConstructor() {
        System.out.println(this.getClass().getSimpleName() + " - postConstructor()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(this.getClass().getSimpleName() + " - preDestroy()");
    }
}
