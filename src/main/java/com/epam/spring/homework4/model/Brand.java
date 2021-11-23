package com.epam.spring.homework4.model;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


/**
 * Class for Brand
 *
 * @author Oleh Savenko
 * @version 1.0
 */
@Data
@Entity
@Table(name = "brand")
public class Brand {
    /**
     * field id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brand_id")
    private int id;
    /**
     * field name
     */
    @NotBlank
    @Column(name="name")
    private String name;

}
