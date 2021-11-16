package com.epam.spring.homework4.controller.mapper;

/**
 * DTO Mapper
 *
 * @param <T> - type for mapping like User, Role etc.
 * @param <K> - DTO type like UserDto, RoleDto
 * @author Oleh Savenko
 * @version 1.0
 */
public interface Mapper<T, K> {
    /**
     * Mapping from DTO object of type K to object of type T
     *
     * @param o - DTO
     * @return data object
     */
    T toObject(K o);

    /**
     * Mapping from object of type T to DTO object of type K
     *
     * @param o data object
     * @return DTO
     */
    K toDto(T o);
}
