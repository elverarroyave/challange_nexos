package com.nexos.challenge.challenge.user.service;

import com.nexos.challenge.challenge.user.model.User;
import com.sun.istack.NotNull;

import java.util.Optional;

public interface UserGateway {
    User create(User userToCreate);

    User findById(@NotNull Long id);

    Optional<User> verifyUserExits(@NotNull Long id);


}
