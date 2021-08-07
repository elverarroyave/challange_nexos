package com.nexos.challenge.challenge.user.io.gateway;

import com.nexos.challenge.challenge.user.io.repository.UserRepository;
import com.nexos.challenge.challenge.user.model.User;
import com.nexos.challenge.challenge.user.service.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserGatewayImpl implements UserGateway {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User userToCreate) {
        return userRepository.save(userToCreate);
    }
}
