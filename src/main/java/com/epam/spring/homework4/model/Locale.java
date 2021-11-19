package com.epam.spring.homework4.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

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
    @NotBlank
    private String name;

    /**
     * filed description
     */
    @NotBlank
    private String description;
}
