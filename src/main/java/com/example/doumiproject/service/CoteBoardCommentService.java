package com.example.doumiproject.service;

import com.example.doumiproject.entity.CoteBoardComment;
import com.example.doumiproject.requestdto.CoteBoardCommentRequestDto;
import com.example.doumiproject.responsedto.CoteBoardCommentResponseDto;
import org.springframework.ui.Model;

import java.util.List;

public interface CoteBoardCommentService {
//    void saveComment(CoteBoardComment comment, long userId, String type);
public List<CoteBoardCommentResponseDto> getAllCoteBoardComments(int postId);
public String saveCoteBoardComment(CoteBoardCommentRequestDto CoteBoardCommentRequestDto);
}
