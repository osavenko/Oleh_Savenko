package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.RoleDto;
import com.epam.spring.homework4.service.CashMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final CashMachineService<RoleDto, Integer> roleService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/role")
    public List<RoleDto> getAllRoles() {
        return roleService.list();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/role/{id}")
    public RoleDto getRole(@PathVariable int id) {
        return roleService.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/role")
    public RoleDto createUser(@RequestBody RoleDto roleDto) {
        return roleService.create(roleDto);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/role/{id}")
    public RoleDto updateUser(@PathVariable int id, @RequestBody RoleDto roleDto) {
        return roleService.update(id, roleDto);
    }

    @DeleteMapping(value = "/role/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
