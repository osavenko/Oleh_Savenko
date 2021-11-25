package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.BrandDto;
import com.epam.spring.homework4.model.Brand;
import com.epam.spring.homework4.repository.BrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BrandServiceImplTest {
    @MockitoSettings(strictness = Strictness.WARN)

    @Mock
    BrandRepository brandRepository;

    @InjectMocks
    BrandServiceImpl brandServiceImpl;

    @Test
    void getBrandByIdTest() {
        Brand expected = new Brand();
        expected.setId(1);
        expected.setName("Laska");
        when(brandRepository.findById(1)).thenReturn(java.util.Optional.of(expected));

        BrandDto actual = brandServiceImpl.get(1);

        assertEquals(expected.getName(), actual.getName());
    }

    @Test
    void listTest() {
        when(brandRepository.findAll()).thenReturn((Collections.singletonList(new Brand())));

        List<BrandDto> actualList = brandServiceImpl.list();

        assertEquals(1, actualList.size());
    }

    @Test
    void addNewBrandTest() {
        Brand brand = new Brand();
        brand.setId(1);
        brand.setName("Laska");
        BrandDto expected = new BrandDto();
        expected.setId(1);
        expected.setName("Laska");
        when(brandRepository.save(brand)).thenReturn(brand);

        BrandDto actual = brandServiceImpl.create(expected);

        assertEquals(expected.getName(), actual.getName());

    }

    @Test
    void updateBrandTest() {
        Brand brand = new Brand();
        brand.setId(1);
        brand.setName("Laska");

        Brand brandSaved = new Brand();
        brandSaved.setId(1);
        brandSaved.setName("Laskaa");


        BrandDto brandDto = new BrandDto();
        brandDto.setId(1);
        brandDto.setName("Laska");

        BrandDto expected = new BrandDto();
        expected.setId(1);
        expected.setName("Laskaa");

        when(brandRepository.save(brand)).thenReturn(brandSaved);

        BrandDto actual = brandServiceImpl.update(1, brandDto);

        assertEquals(expected, actual);
    }

    @Test
    void deleteBrandByIdTest() {
        doNothing().when(brandRepository).deleteById(1);

        brandServiceImpl.delete(1);

        verify(brandRepository, times(1)).deleteById(1);
    }
}