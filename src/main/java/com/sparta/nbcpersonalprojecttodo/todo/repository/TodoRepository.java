package com.sparta.nbcpersonalprojecttodo.todo.repository;

import com.sparta.nbcpersonalprojecttodo.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findAll(Pageable pageable);
}
