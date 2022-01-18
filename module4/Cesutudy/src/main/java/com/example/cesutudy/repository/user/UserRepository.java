package com.example.cesutudy.repository.user;

import com.example.cesutudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
    Boolean existsByUserName(String account);
    User findByEmployee_EmployeeEmail(String email);
}
