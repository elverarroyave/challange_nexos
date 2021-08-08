package com.nexos.challenge.challenge.role.io.gateway;

import com.nexos.challenge.challenge.config.exeption.NotFoundExeption;
import com.nexos.challenge.challenge.role.io.repository.RoleRepository;
import com.nexos.challenge.challenge.role.model.Role;
import com.nexos.challenge.challenge.role.service.RoleGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleGatewayImpl implements RoleGateway {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role create(Role roleToCreate) {
        return roleRepository.save(roleToCreate);
    }

    @Override
    public Role findById(Long id){
        return roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("Role id not found. Check your id please"));
    }
}
