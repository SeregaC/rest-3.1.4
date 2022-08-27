package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

   UserService userService;

    public UserDetailsServiceImp(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

            User user = userService.findUserByEmail(email);

            if (user == null) {
                throw new UsernameNotFoundException(String.format("Пользователь с именем '%s' не найден", email));
            }

            return user;
        }
    }

