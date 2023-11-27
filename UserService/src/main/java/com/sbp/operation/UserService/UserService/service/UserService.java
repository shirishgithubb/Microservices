package com.sbp.operation.UserService.UserService.service;

import com.sbp.operation.UserService.UserService.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    User getUserById(String id);
    List<User> getAllUser();

    void deleteUserById(String id);

    User updateUser(User user);
}
