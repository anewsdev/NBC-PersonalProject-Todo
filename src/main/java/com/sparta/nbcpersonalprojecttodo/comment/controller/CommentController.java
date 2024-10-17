package com.sparta.nbcpersonalprojecttodo.comment.controller;

import com.sparta.nbcpersonalprojecttodo.comment.dto.CommentRequestDto;
import com.sparta.nbcpersonalprojecttodo.comment.dto.CommentResponseDto;
import com.sparta.nbcpersonalprojecttodo.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    //댓글 작성
    @PostMapping
    public CommentResponseDto createComment(@RequestBody @Valid CommentRequestDto requestDto){
        return commentService.createComment(requestDto);
    }

    //댓글 전체 조회
    @GetMapping
    public List<CommentResponseDto> getAllComments(){
        List<CommentResponseDto> comments = commentService.getAllComment();
        return comments;
    }

    //댓글 단건 조회
    @GetMapping("/{todoId}")
    public List<CommentResponseDto> getCommentByTodoId(@PathVariable Long todoId){
        List<CommentResponseDto> comments = commentService.getCommentByTodoId(todoId);
        return comments;
    }

    //댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long commentId, @RequestBody @Valid CommentRequestDto requestDto){
        commentService.updateComment(commentId, requestDto);
        return ResponseEntity.ok().build();  // 200 OK 반환
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();  // 204 No Content 반환
    }

}
