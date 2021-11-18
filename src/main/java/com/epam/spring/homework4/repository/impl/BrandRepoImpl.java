package com.epam.spring.homework4.repository.impl;

import com.epam.spring.homework4.model.Brand;
import com.epam.spring.homework4.repository.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BrandRepoImpl implements Repository<Brand, Integer> {

    private final List<Brand> brands = new ArrayList<>();

    @Override
    public Brand get(Integer key) {
        return brands.stream()
                .filter(user -> user.getId() == key)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found!"));
    }

    @Override
    public List<Brand> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(brands));
    }

    @Override
    public Brand create(Brand brand) {
        brands.add(brand);
        return brand;
    }

    @Override
    public Brand update(Integer key, Brand brand) {
        boolean isDeleted = brands.removeIf(u -> u.getId() == key);
        if (isDeleted) {
            brands.add(brand);
        } else {
            throw new RuntimeException("User is not found!");
        }
        return brand;
    }

    @Override
    public void delete(Integer key) {
        brands.removeIf(user -> user.getId() == key);
    }
}
