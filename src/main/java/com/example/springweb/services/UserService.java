package com.example.springweb.services;

import com.example.springweb.domain.User;

import javax.management.relation.Role;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);
    List<User> getUsers();

}
