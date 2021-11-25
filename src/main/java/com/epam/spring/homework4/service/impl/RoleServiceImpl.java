package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.RoleDto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;
import com.epam.spring.homework4.controller.mapper.Mapper;
import com.epam.spring.homework4.controller.mapper.MapperFactory;
import com.epam.spring.homework4.repository.RoleRepository;
import com.epam.spring.homework4.service.RoleService;
import com.epam.spring.homework4.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleDto get(Integer id) {
        log.info("getRole by id {}", id);
        Optional<Role> role = roleRepository.findById(id);
        return mapRoleToRoleDto(role.get());
    }

    @Override
    public List<RoleDto> list() {
        log.info("get all roles");
        List<Role> roles = roleRepository.findAll();
        return roles
                .stream()
                .map(this::mapRoleToRoleDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto create(RoleDto dto) {
        log.info("create Role with id {}", dto.getId());
        Role role = mapRoleDtoToRole(dto);
        role = roleRepository.save(role);
        return mapRoleToRoleDto(role);
    }

    @Override
    public RoleDto update(Integer key, RoleDto dto) {
        log.info("update Role with id {}", key);
        Role role = mapRoleDtoToRole(dto);
        role = roleRepository.save(role);
        return mapRoleToRoleDto(role);
    }

    @Override
    public void delete(Integer key) {
        log.info("delete Role with id {}", key);
        roleRepository.deleteById(key);
    }

    private RoleDto mapRoleToRoleDto(Role role) {
        return getMapper().toDto(role);
    }

    private Role mapRoleDtoToRole(RoleDto dto) {
        return getMapper().toObject(dto);
    }

    private Mapper<Role, RoleDto> getMapper() {
        Mapper<Role, RoleDto> mapper = null;
        try {
            mapper = MapperFactory.getMapper(new RoleDto());
        } catch (UnknownDtoException e) {
            log.error("Error when mapping Role to RoleDto", e);
            throw new RuntimeException("Error when mapping User to RoleDto", e);
        }
        return mapper;
    }
}
