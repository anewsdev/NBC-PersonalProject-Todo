package com.sparta.nbcpersonalprojecttodo.comment.service;

import com.sparta.nbcpersonalprojecttodo.comment.dto.CommentRequestDto;
import com.sparta.nbcpersonalprojecttodo.comment.dto.CommentResponseDto;
import com.sparta.nbcpersonalprojecttodo.comment.entity.Comment;
import com.sparta.nbcpersonalprojecttodo.todo.entity.Todo;
import com.sparta.nbcpersonalprojecttodo.comment.repository.CommentRepository;
import com.sparta.nbcpersonalprojecttodo.todo.repository.TodoRepository;
import com.sparta.nbcpersonalprojecttodo.user.entity.User;
import com.sparta.nbcpersonalprojecttodo.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        //todoId로 일정 있는지 확인
        Todo todo = todoRepository.findById(requestDto.getTodoId())
                .orElseThrow(()-> new IllegalArgumentException("해당 일정이 없습니다."));

        Comment comment = Comment.builder()
                .content(requestDto.getContent())
                .user(user)
                .todo(todo)
                .build();

        //comment 저장
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }

    @Transactional
    public List<CommentResponseDto> getAllComment() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CommentResponseDto> getCommentByTodoId(Long todoId) {
        List<Comment> comments = commentRepository.findAllByTodoId(todoId);
        return comments.stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentResponseDto updateComment(Long commentId, CommentRequestDto requestDto) {
        //댓글 조회
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));
        //작성자 확인
        if(!comment.getUser().getId().equals(requestDto.getUserId())) {
            throw new RuntimeException("댓글 수정 권한이 없습니다.");
        }
        comment.update(requestDto.getContent());


        //수정된 댓글을 반환
        return new CommentResponseDto(comment);
    }
    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new IllegalArgumentException("해당 댓글이 없습니다."));
        commentRepository.delete(comment);
    }
}
