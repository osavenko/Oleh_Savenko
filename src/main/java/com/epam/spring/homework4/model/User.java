package com.epam.spring.homework4.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * Class for User
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Data
@Builder
public class User {
    /**
     * field id
     */
    private int id;
    /**
     * field name
     */
    @NotBlank
    private String name;
    /**
     * field roleId
     */
    @Positive
    private int roleId;
    /**
     * field localeId
     */
    @Positive
    private int localeId;
    /**
     * field activated
     */
    private boolean activated;
}
