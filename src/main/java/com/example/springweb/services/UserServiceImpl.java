package com.example.springweb.services;

import com.example.springweb.domain.User;
import com.example.springweb.repo.RoleRepo;
import com.example.springweb.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.util.List;

/*
* @author - Giovanni EVC
* @version - 1.00
* @since - 29/12/2021
*/

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user to the database");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new Role {} to the database", role.getRoleName() );
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        log.info("Adding role {} to user {}", roleName, username);

        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByRoleName(roleName);

        user.getRoles().add(role); // error

    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {} to user {}", username);

        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

}
