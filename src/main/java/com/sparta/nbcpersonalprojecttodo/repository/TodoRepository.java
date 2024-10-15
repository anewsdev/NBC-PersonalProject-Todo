package com.sparta.nbcpersonalprojecttodo.repository;

import com.sparta.nbcpersonalprojecttodo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
