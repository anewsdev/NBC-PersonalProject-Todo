package com.sparta.nbcpersonalprojecttodo.comment.repository;

import com.sparta.nbcpersonalprojecttodo.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByTodoId(Long todoId);
}
