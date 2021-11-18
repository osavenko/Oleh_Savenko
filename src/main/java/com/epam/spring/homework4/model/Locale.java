package com.epam.spring.homework4.model;

import lombok.Builder;
import lombok.Data;

/**
 * Class for Locale
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Data
@Builder
public class Locale {
    /**
     * field id
     */
    private int id;
    /**
     * field name
     */
    private String name;
    /**
     * filed description
     */
    private String description;
}
