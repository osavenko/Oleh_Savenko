package com.epam.spring.homework4.controller.annatation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Mark DTO class
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Dto {
    String className();
}
