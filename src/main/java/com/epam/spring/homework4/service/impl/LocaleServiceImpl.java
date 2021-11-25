package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.LocaleDto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;
import com.epam.spring.homework4.controller.mapper.Mapper;
import com.epam.spring.homework4.controller.mapper.MapperFactory;
import com.epam.spring.homework4.model.Locale;
import com.epam.spring.homework4.repository.LocaleRepository;
import com.epam.spring.homework4.service.LocaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocaleServiceImpl implements LocaleService {

    private final LocaleRepository localeRepository;

    @Override
    public LocaleDto get(Integer key) {
        log.info("get locale by id: " + key);
        Optional<Locale> locale = localeRepository.findById(key);
        return mapLocaleToLocaleDto(locale.get());
    }

    @Override
    public List<LocaleDto> list() {
        log.info("get all locales");
        List<Locale> locales = localeRepository.findAll();
        return locales
                .stream()
                .map(this::mapLocaleToLocaleDto)
                .collect(Collectors.toList());
    }

    @Override
    public LocaleDto create(LocaleDto dto) {
        log.info("create Locale with id {}", dto.getId());
        Locale locale = mapLocaleDtoToLocale(dto);
        locale = localeRepository.save(locale);
        return mapLocaleToLocaleDto(locale);
    }

    @Override
    public LocaleDto update(Integer id, LocaleDto dto) {
        log.info("save Locale with id {}",dto.getId());
        Locale locale = mapLocaleDtoToLocale(dto);
        locale.setId(id);
        locale = localeRepository.save(locale);
        return mapLocaleToLocaleDto(locale);
    }

    @Override
    public void delete(Integer key) {
        log.info("delete Locale with id {}", key);
        localeRepository.deleteById(key);
    }

    private LocaleDto mapLocaleToLocaleDto(Locale locale) {
        return getMapper().toDto(locale);
    }

    private Locale mapLocaleDtoToLocale(LocaleDto dto) {
        return getMapper().toObject(dto);
    }

    private Mapper<Locale, LocaleDto> getMapper() {
        Mapper<Locale, LocaleDto> mapper = null;
        try {
            mapper = MapperFactory.getMapper(new LocaleDto());
        } catch (UnknownDtoException e) {
            log.error("Error when mapping Locale, LocaleDto", e);
            throw new RuntimeException("Error when mapping Locale, LocaleDto", e);
        }
        return mapper;
    }


}
