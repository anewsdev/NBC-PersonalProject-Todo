package com.sparta.nbcpersonalprojecttodo.user.repository;

import com.sparta.nbcpersonalprojecttodo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String authorUsername);
}
