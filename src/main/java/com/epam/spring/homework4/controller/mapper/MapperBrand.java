package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.BrandDto;
import com.epam.spring.homework4.model.Brand;
import javafx.util.Builder;

public class MapperBrand implements Mapper<Brand, BrandDto> {

    MapperBrand() {
    }

    @Override
    public Brand toObject(BrandDto dto) {
        Brand brand = new Brand();
        brand.setId(dto.getId());
        brand.setName(dto.getName());
        return brand;
    }

    @Override
    public BrandDto toDto(Brand o) {
        BrandDto dto = new BrandDto();
        dto.setId(o.getId());
        dto.setName(o.getName());
        return dto;
    }
}
