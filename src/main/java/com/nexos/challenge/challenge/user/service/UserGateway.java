package com.nexos.challenge.challenge.user.service;

import com.nexos.challenge.challenge.user.model.User;

public interface UserGateway {
    User create(User userToCreate);
}
