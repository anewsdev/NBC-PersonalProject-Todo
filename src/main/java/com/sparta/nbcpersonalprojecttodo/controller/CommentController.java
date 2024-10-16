package com.sparta.nbcpersonalprojecttodo.controller;

import com.sparta.nbcpersonalprojecttodo.dto.CommentRequestDto;
import com.sparta.nbcpersonalprojecttodo.dto.CommentResponseDto;
import com.sparta.nbcpersonalprojecttodo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{todoId}")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long todoId){
        return commentService.createComment(requestDto, todoId);

    }

    @GetMapping
    public List<CommentResponseDto> getAllComments(){
        List<CommentResponseDto> comments = commentService.getAllComment();
        return comments;
    }

}
