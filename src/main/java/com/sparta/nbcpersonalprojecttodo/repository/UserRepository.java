package com.sparta.nbcpersonalprojecttodo.repository;

import com.sparta.nbcpersonalprojecttodo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
