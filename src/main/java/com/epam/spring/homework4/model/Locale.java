package com.epam.spring.homework4.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Class for Locale
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Data
@Builder
@Entity
@Table(name = "locale")
public class Locale {
    /**
     * field id
     */
    @Id
    private int id;
    /**
     * field name
     */
    @NotBlank
    @Column(name = "name")
    private String name;

    /**
     * filed description
     */
    @NotBlank
    @Column(name = "description")
    private String description;
}
