package com.sparta.nbcpersonalprojecttodo.repository;

import com.sparta.nbcpersonalprojecttodo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByTodoId(Long todoId);
}
