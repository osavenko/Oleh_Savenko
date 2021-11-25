package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.Locale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleRepository extends JpaRepository<Locale, Integer> {
}
