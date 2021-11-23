package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.BrandDto;
import com.epam.spring.homework4.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/brand")
    public List<BrandDto> getAllRoles() {
        return brandService.list();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/brand/{id}")
    public BrandDto getBrand(@PathVariable("id") @Min(1) int id) {
        return brandService.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/brand")
    public BrandDto createBrand(@Valid @RequestBody BrandDto brandDto) {

        return brandService.create(brandDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/brand/{id}")
    public BrandDto updateBrand(@PathVariable("id") @Min(1) int id, @Valid @RequestBody BrandDto brandDto) {
        return brandService.update(id, brandDto);
    }

    @DeleteMapping(value = "/brand/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") @Min(1) int id) {
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
