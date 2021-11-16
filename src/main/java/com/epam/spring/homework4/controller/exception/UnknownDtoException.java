package com.epam.spring.homework4.controller.exception;

/**
 * Throw when unknown dto object
 *
 * @author Oleh Savenko
 * @version 1.0
 */
public class UnknownDtoException extends Exception {

    public UnknownDtoException(String message) {
        super(message);
    }
}
