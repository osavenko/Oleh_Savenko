package com.epam.spring.homework4.service;

import java.util.List;

/**
 * Service work with type T and type of Key of object type of T
 *
 * @param <T> - Type object
 * @param <E> - Type key of object
 * @author Oleh Savenko
 * @version 1.0
 */

public interface CashMachineService<T, E> {

    /**
     * Get object by key
     *
     * @param key
     * @return
     */
    T get(E key);

    /**
     * Retrieve all objects
     *
     * @return List of objects
     */
    List<T> list();

    /**
     * Add object to repository
     *
     * @param dto -DTO
     * @return
     */
    T create(T dto);

    /**
     * Update object t by key key
     *
     * @param id - key of object
     * @param dto - DTO
     * @return
     */
    T update(E id, T dto);

    /**
     * Delete object by key
     *
     * @param key
     */
    void delete(E key);
}
