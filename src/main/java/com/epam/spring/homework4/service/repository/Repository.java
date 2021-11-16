package com.epam.spring.homework4.service.repository;

import java.util.List;

/**
 * Repository work with type T and type of Key of object type of T
 *
 * @param <T>   - Type object
 * @param <Key> - Type key of object
 * @author Oleh Savenko
 * @version 1.0
 */
public interface Repository<T, Key> {

    /**
     * Get object by key
     *
     * @param key
     * @return
     */
    T get(Key key);

    /**
     * Retrieve all objects
     *
     * @return List of objects
     */
    List<T> getAll();

    /**
     * Add object to repository
     *
     * @param t
     * @return
     */
    T create(T t);

    /**
     * Update object t by key key
     *
     * @param key - key of object
     * @param t   - object
     * @return
     */
    T update(Key key, T t);

    /**
     * Delete object by key
     *
     * @param key
     */
    void delete(Key key);
}
