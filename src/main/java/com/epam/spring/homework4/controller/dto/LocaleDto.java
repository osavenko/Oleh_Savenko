package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.controller.annatation.Dto;
import lombok.Data;

/**
 * DTO class for Locale
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Data
@Dto(className = "Locale")
public class LocaleDto {
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
