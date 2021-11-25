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
    void givenLocaleDto_whenToObject_thenLocale() {
        localeDto.setId(1);
        localeDto.setName("ua");

        Locale actual = mapper.toObject(localeDto);

        Locale expected = new Locale();
        expected.setId(1);
        expected.setName("ua");

        assertEquals(expected, actual);
    }

    @Test
    void givenLocale_whenToDto_thenLocaleDto() {
        Locale locale =new  Locale();
        locale.setId(1);
        locale.setName("ua");

        LocaleDto expected = mapper.toDto(locale);

        LocaleDto actual = new LocaleDto();
        actual.setId(1);
        actual.setName("ua");

        assertEquals(expected, actual);
    }

}