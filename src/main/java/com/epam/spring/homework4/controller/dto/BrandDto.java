package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.controller.annatation.Dto;
import lombok.Data;

/**
 * DTO class for Brand
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Data
@Dto(className = "Brand")
public class BrandDto {
    /**
     * field id
     */
    private int id;
    /**
     * field name
     */
    private String name;
}
