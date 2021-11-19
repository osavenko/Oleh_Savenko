package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.BrandDto;
import com.epam.spring.homework4.controller.dto.LocaleDto;
import com.epam.spring.homework4.controller.dto.RoleDto;
import com.epam.spring.homework4.controller.dto.UserDto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;
import com.epam.spring.homework4.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapperFactoryTest {

    @Test
    void givenUserDto_whenMapperFactoryGetMapper_thenMapperUser() throws UnknownDtoException {
        Mapper<User, UserDto> mapperUser = MapperFactory.getMapper(new UserDto());
        Class actual = mapperUser.getClass();

        Class expected = MapperUser.class;

        assertEquals(actual, expected);
    }

    @Test
    void givenRoleDto_whenMapperFactoryGetMapper_thenMapperRole() throws UnknownDtoException {
        Mapper<User, RoleDto> mapperUser = MapperFactory.getMapper(new RoleDto());
        Class actual = mapperUser.getClass();

        Class expected = MapperRole.class;

        assertEquals(actual, expected);
    }

    @Test
    void givenLocaleDto_whenMapperFactoryGetMapper_thenMapperLocale() throws UnknownDtoException {
        Mapper<User, LocaleDto> mapperUser = MapperFactory.getMapper(new LocaleDto());
        Class actual = mapperUser.getClass();

        Class expected = MapperLocale.class;

        assertEquals(actual, expected);
    }

    @Test
    void givenBrandDto_whenMapperFactoryGetMapper_thenMapperBrand() throws UnknownDtoException {
        Mapper<User, BrandDto> mapperUser = MapperFactory.getMapper(new BrandDto());
        Class actual = mapperUser.getClass();

        Class expected = MapperBrand.class;

        assertEquals(actual, expected);
    }

    @Test
    void givenObject_whenMapperFactoryGetMapper_thenUnknownDtoException() {
        UnknownDtoException exception = assertThrows(UnknownDtoException.class, () -> {
            MapperFactory.getMapper(new Object());
        });

        String expected = "Unknown DTO class";
        String actual = exception.getMessage();

        assertTrue(actual.contains(expected));
    }
}