package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.controller.annatation.Dto;
import lombok.Data;

/**
 * DTO class for Role
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Data
@Dto(className = "Role")
public class RoleDto {
    /**
     * field id
     */
    private int id;
    /**
     * field name
     */
    private String name;
}
