package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.BrandDto;
import com.epam.spring.homework4.controller.dto.LocaleDto;
import com.epam.spring.homework4.service.LocaleService;
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
public class LocaleController {

    private final LocaleService localeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/locale")
    public List<LocaleDto> getAllLocales() {
        return localeService.list();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/locale/{id}")
    public LocaleDto getLocale(@PathVariable("id") @Min(1) int id) {
        return localeService.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/locale")
    public LocaleDto createLocale(@Valid @RequestBody LocaleDto localeDto) {
        return localeService.create(localeDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/locale/{id}")
    public LocaleDto updateLocale(@PathVariable("id") @Min(1) int id, @Valid @RequestBody LocaleDto localeDto) {
        return localeService.update(id, localeDto);
    }

    @DeleteMapping(value = "/locale/{id}")
    public ResponseEntity<Void> deleteLocale(@PathVariable("id") @Min(1) int id) {
        localeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
