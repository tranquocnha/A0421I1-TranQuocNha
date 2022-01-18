package com.example.cesutudy.service.role;

import com.example.cesutudy.model.Role;
import com.example.cesutudy.repository.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }
}
