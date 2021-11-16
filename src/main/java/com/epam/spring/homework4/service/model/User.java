package com.epam.spring.homework4.service.model;

import lombok.Builder;
import lombok.Data;

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
    private String name;
    /**
     * field roleId
     */
    private int roleId;
    /**
     * field localeId
     */
    private int localeId;
    /**
     * field activated
     */
    private boolean activated;
}
