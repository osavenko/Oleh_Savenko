package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.BrandDto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;
import com.epam.spring.homework4.model.Brand;
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

        Brand expected = new Brand();
        expected.setId(1);
        expected.setName("Laska");
        assertEquals(expected, actual);
    }

    @Test
    void givenRole_whenToDto_thenRoleDto() {
        Brand brand = new Brand();
        brand.setId(1);
        brand.setName("Laska");

        BrandDto expected = mapper.toDto(brand);

        BrandDto actual = new BrandDto();
        actual.setId(1);
        actual.setName("Laska");

        assertEquals(expected, actual);
    }
}