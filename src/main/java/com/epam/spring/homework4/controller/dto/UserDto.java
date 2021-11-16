package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.controller.annatation.Dto;
import lombok.Data;

/**
 * DTO class for User
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Data
@Dto(className = "User")
public class UserDto {
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
