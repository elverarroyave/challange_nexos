package com.nexos.challenge.challenge.user.io.gateway;

import com.nexos.challenge.challenge.config.MessageResponse;
import com.nexos.challenge.challenge.config.exeption.NotFoundExeption;
import com.nexos.challenge.challenge.user.io.repository.UserRepository;
import com.nexos.challenge.challenge.user.model.User;
import com.nexos.challenge.challenge.user.service.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserGatewayImpl implements UserGateway {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User userToCreate) {
        return userRepository.save(userToCreate);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new NotFoundExeption("User id not found, please check your id"));
    }

    @Override
    public Optional<User> verifyUserExits(Long id) {
        return userRepository.findById(id);
    }
}
