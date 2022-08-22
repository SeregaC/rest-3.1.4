package ru.kata.spring.boot_security.demo.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.Model.Role;
import ru.kata.spring.boot_security.demo.Model.User;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {


    List<User> allUsers();

    User findUserById(Long userId);

    boolean saveUser(User user);

    boolean deleteUser(Long userId);

    void updateUser(User user);

    User findUserByName(String userName);

    List<Role> listRoles();


}
