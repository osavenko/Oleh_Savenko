package com.epam.spring.homework4.service.model;

import lombok.Builder;
import lombok.Data;

/**
 * Class for Role
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Data
@Builder
public class Role {
    /**
     * field id
     */
    private int id;
    /**
     * field name
     */
    private String name;
}
