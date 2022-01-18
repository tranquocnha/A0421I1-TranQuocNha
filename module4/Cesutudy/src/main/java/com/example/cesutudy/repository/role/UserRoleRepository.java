package com.example.cesutudy.repository.role;

import com.example.cesutudy.model.Role;
import com.example.cesutudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<Role,Integer> {
    List<Role> findByUsers(User user);
}
