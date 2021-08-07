package com.nexos.challenge.challenge.role.service;

import com.nexos.challenge.challenge.role.model.Role;
import com.sun.istack.NotNull;
import javassist.NotFoundException;

public interface RoleGateway {
    Role create(@NotNull  Role roleToCreate);
    
    Role findById(@NotNull Long id) throws NotFoundException;
}
