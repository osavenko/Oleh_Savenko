package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.controller.annatation.Dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Dto(className = "User")
public class UserIdNameDto {
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
}
