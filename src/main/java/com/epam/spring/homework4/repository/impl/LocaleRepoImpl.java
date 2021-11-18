package com.epam.spring.homework4.repository.impl;

import com.epam.spring.homework4.model.Locale;
import com.epam.spring.homework4.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class LocaleRepoImpl implements Repository<Locale, Integer> {
    private final List<Locale> locales = new ArrayList<>();

    @Override
    public Locale get(Integer key) {
        return locales.stream()
                .filter(user -> user.getId() == key)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Locale is not found!"));
    }

    @Override
    public List<Locale> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(locales));
    }

    @Override
    public Locale create(Locale locale) {
        locales.add(locale);
        return locale;
    }

    @Override
    public Locale update(Integer key, Locale locale) {
        boolean isDeleted = locales.removeIf(u -> u.getId() == key);
        if (isDeleted) {
            locales.add(locale);
        } else {
            throw new RuntimeException("User is not found!");
        }
        return locale;
    }

    @Override
    public void delete(Integer key) {
        locales.removeIf(user -> user.getId() == key);
    }
}
