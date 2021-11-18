package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.LocaleDto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;
import com.epam.spring.homework4.model.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperLocaleTest {

    private Mapper<Locale, LocaleDto> mapper;
    private LocaleDto localeDto;

    @BeforeEach
    void setUp() throws UnknownDtoException {
        localeDto = new LocaleDto();
        mapper = MapperFactory.getMapper(localeDto);
    }

    @Test
    void givenRoleDto_whenToObject_thenRole() {
        localeDto.setId(1);
        localeDto.setName("ua");

        Locale actual = mapper.toObject(localeDto);

        Locale expected = Locale.builder()
                .id(1)
                .name("ua")
                .build();
        assertEquals(expected, actual);
    }

    @Test
    void givenRole_whenToDto_thenRoleDto() {
        Locale locale = Locale.builder()
                .id(1)
                .name("ua")
                .build();
        LocaleDto expected = mapper.toDto(locale);

        LocaleDto actual = new LocaleDto();
        actual.setId(1);
        actual.setName("ua");

        assertEquals(expected, actual);
    }

}