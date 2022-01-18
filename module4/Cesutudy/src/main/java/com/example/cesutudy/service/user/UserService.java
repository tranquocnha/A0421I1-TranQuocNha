package com.example.cesutudy.service.user;

import com.example.cesutudy.model.User;

public interface UserService {
    boolean checkAccount(String userName);

    User findByName(String name);
}
