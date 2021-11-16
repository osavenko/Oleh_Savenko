package com.epam.spring.homework4.service.repository.impl;

import com.epam.spring.homework4.service.model.Role;
import com.epam.spring.homework4.service.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RoleRepoIml implements Repository<Role, Integer> {

    private final List<Role> roles = new ArrayList<>();

    @Override
    public Role get(Integer key) {
        return roles.stream()
                .filter(user -> user.getId() == key)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Role is not found!"));
    }

    @Override
    public List<Role> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(roles));
    }

    @Override
    public Role create(Role role) {
        roles.add(role);
        return role;
    }

    @Override
    public Role update(Integer key, Role role) {
        boolean isDeleted = roles.removeIf(u -> u.getId() == key);
        if (isDeleted) {
            roles.add(role);
        } else {
            throw new RuntimeException("Role is not found!");
        }
        return role;
    }

    @Override
    public void delete(Integer key) {
        roles.removeIf(user -> user.getId() == key);
    }
}
