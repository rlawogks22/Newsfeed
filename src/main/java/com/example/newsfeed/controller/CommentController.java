package com.example.newsfeed.controller;

import com.example.newsfeed.dto.CommentRequestDto;
import com.example.newsfeed.dto.CommonResponseDto;
import com.example.newsfeed.dto.MenuResponseDto;
import com.example.newsfeed.dto.CommentRequestDto;
import com.example.newsfeed.service.CommentService;
import com.example.newsfeed.userdetails.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.RejectedExecutionException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommonResponseDto> post(@RequestBody CommentRequestDto commentRequestDto,
                                                  @AuthenticationPrincipal UserDetailsImpl userDetails){
        MenuResponseDto menuResponseDto;
        try{
            menuResponseDto = commentService.creataComment(commentRequestDto,userDetails);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.status(HttpStatus.OK.value()).
                body(menuResponseDto);
    }
    @PutMapping("/{commentId}")
    public ResponseEntity<CommonResponseDto> update(@RequestBody CommentRequestDto commentRequestDto,
                                                  @AuthenticationPrincipal UserDetailsImpl userDetails,
                                                  @PathVariable Long commentId){
        MenuResponseDto menuResponseDto;
        try{
            menuResponseDto = commentService.updateComment(commentRequestDto, userDetails, commentId);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        } catch (RejectedExecutionException e){
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.status(HttpStatus.OK.value()).
                body(menuResponseDto);
    }
    @DeleteMapping("{commentId}")
    public ResponseEntity<CommonResponseDto> delete(@RequestBody CommentRequestDto commentRequestDto,
                                                  @AuthenticationPrincipal UserDetailsImpl userDetails,
                                                  @PathVariable Long commentId) {
        MenuResponseDto menuResponseDto;
        try{
            menuResponseDto = commentService.deleteComment(commentRequestDto, userDetails, commentId);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        } catch (RejectedExecutionException e){
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.status(HttpStatus.OK.value()).
                body(menuResponseDto);
    }
}
