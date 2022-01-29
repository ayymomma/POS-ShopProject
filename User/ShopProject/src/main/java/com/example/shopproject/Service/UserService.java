package com.example.shopproject.Service;

import com.example.shopproject.Model.Entity.User;
import com.example.shopproject.Repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(10, new SecureRandom());

    public String signIn(String username, String password) {
        Optional<User> optionalUser = userRepository.findByName(username);
        if (optionalUser.isPresent()) {
            var user = optionalUser.get();
            if (encoder.matches(password, user.getPassword())) {
                String token = UUID.randomUUID().toString();
                user.setToken(token);
                userRepository.save(user);
                return token;
            }
        }
        return StringUtils.EMPTY;
    }

    public String signUp(String username, String password) {
        if (userRepository.existsByName(username)){
            return StringUtils.EMPTY;
        }
        var user = new User();
        String token = UUID.randomUUID().toString();
        user.setName(username);
        user.setPassword(encoder.encode(password));
        user.setToken(token);
        userRepository.save(user);
        return token;
    }


    public Optional<User> findByToken(String token) {
       return userRepository.findByToken(token);
    }


}