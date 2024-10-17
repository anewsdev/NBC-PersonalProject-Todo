package com.sparta.nbcpersonalprojecttodo.userTodo.repository;

import com.sparta.nbcpersonalprojecttodo.userTodo.entity.UserTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTodoRepository extends JpaRepository<UserTodo, Long> {
}
