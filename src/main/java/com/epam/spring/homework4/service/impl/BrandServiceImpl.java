package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.BrandDto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;
import com.epam.spring.homework4.controller.mapper.Mapper;
import com.epam.spring.homework4.controller.mapper.MapperFactory;
import com.epam.spring.homework4.model.Brand;
import com.epam.spring.homework4.repository.BrandRepository;
import com.epam.spring.homework4.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public BrandDto get(Integer key) {
        log.info("Get brand by Id{}" + key);
        Optional<Brand> brand = brandRepository.findById(key);
        return mapBrandToBrandDto(brand.get());
    }

    @Override
    public List<BrandDto> list() {
        log.info("get all brands");
        List<Brand> all = brandRepository.findAll();
        return all.stream()
                .map(this::mapBrandToBrandDto)
                .collect(Collectors.toList());
    }

    @Override
    public BrandDto create(BrandDto dto) {
        log.info("create Brand with id {}", dto.getId());
        Brand brand = mapBrandDtoToBrand(dto);
        brand = brandRepository.save(brand);
        return mapBrandToBrandDto(brand);
    }

    @Override
    public BrandDto update(Integer id, BrandDto dto) {
        log.info("save Brand with id {}", dto.getId());
        Brand brand = mapBrandDtoToBrand(dto);
        brand.setId(id);
        brand = brandRepository.save(brand);
        return mapBrandToBrandDto(brand);
    }

    @Override
    public void delete(Integer key) {
        log.info("save Brand with id {}", key);
        brandRepository.deleteById(key);
    }

    private BrandDto mapBrandToBrandDto(Brand brand) {
        return getMapper().toDto(brand);
    }

    private Brand mapBrandDtoToBrand(BrandDto dto) {
        return getMapper().toObject(dto);
    }

    private Mapper<Brand, BrandDto> getMapper() {
        Mapper<Brand, BrandDto> mapper = null;
        try {
            mapper = MapperFactory.getMapper(new BrandDto());
        } catch (UnknownDtoException e) {
            log.error("Error when mapping Brand to BrandDto", e);
            throw new RuntimeException("Error when mapping Brand to BrandDto", e);
        }
        return mapper;
    }
}
