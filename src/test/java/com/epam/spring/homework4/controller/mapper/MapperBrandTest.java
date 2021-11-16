package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.BrandDto;
import com.epam.spring.homework4.controller.dto.RoleDto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;
import com.epam.spring.homework4.service.model.Brand;
import com.epam.spring.homework4.service.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapperBrandTest {

    private Mapper<Brand, BrandDto> mapper;
    private BrandDto brandDto;

    @BeforeEach
    void setUp() throws UnknownDtoException {
        brandDto = new BrandDto();
        mapper = MapperFactory.getMapper(brandDto);
    }

    @Test
    void givenRoleDto_whenToObject_thenRole() {
        brandDto.setId(1);
        brandDto.setName("Laska");

        Brand actual = mapper.toObject(brandDto);

        Brand expected = Brand.builder()
                .id(1)
                .name("Laska")
                .build();
        assertEquals(expected, actual);
    }

    @Test
    void givenRole_whenToDto_thenRoleDto() {
        Brand brand = Brand.builder()
                .id(1)
                .name("Laska")
                .build();
        BrandDto expected = mapper.toDto(brand);

        BrandDto actual = new BrandDto();
        actual.setId(1);
        actual.setName("Laska");

        assertEquals(expected, actual);
    }
}