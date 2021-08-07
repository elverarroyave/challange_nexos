package com.nexos.challenge.challenge.user.io.repository;

import com.nexos.challenge.challenge.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
