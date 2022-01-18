package com.example.cesutudy.service.user;

import com.example.cesutudy.model.User;
import com.example.cesutudy.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean checkAccount(String account) {
        return false;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByUserName(name);
    }
}
