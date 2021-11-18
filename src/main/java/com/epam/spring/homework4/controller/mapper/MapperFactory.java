package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.annatation.Dto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;

import java.lang.annotation.Annotation;

public class MapperFactory {

    public static Mapper getMapper(Object o) throws UnknownDtoException {
        Class clazz = o.getClass();
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Dto) {
                Dto dto = (Dto) annotation;
                if ("User".equals(dto.className())) {
                    return new MapperUser();
                }
            }
            if (annotation instanceof Dto) {
                Dto dto = (Dto) annotation;
                if ("Role".equals(dto.className())) {
                    return new MapperRole();
                }
            }
            if (annotation instanceof Dto) {
                Dto dto = (Dto) annotation;
                if ("Brand".equals(dto.className())) {
                    return new MapperBrand();
                }
            }
            if (annotation instanceof Dto) {
                Dto dto = (Dto) annotation;
                if ("Locale".equals(dto.className())) {
                    return new MapperLocale();
                }
            }

        }
        throw new UnknownDtoException("Unknown DTO class " + clazz.getCanonicalName());
    }
}
