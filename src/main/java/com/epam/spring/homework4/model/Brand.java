package com.epam.spring.homework4.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * Class for Brand
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Data
@Builder
public class Brand {
    /**
     * field id
     */
    private int id;
    /**
     * field name
     */
    @NotBlank
    private String name;
}
