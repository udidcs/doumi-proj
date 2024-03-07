package com.example.doumiproject.service;

import com.example.doumiproject.entity.CoteBoard;
import com.example.doumiproject.entity.CoteBoardComment;
import com.example.doumiproject.repository.CoteBoardCommentRepository;
import com.example.doumiproject.requestdto.CoteBoardCommentRequestDto;
import com.example.doumiproject.responsedto.CoteBoardCommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoteBoradCommentServiceImpl implements CoteBoardCommentService {
    private final CoteBoardCommentRepository coteBoardCommentRepository;

    @Override
    public List<CoteBoardCommentResponseDto> getAllCoteBoardComments(int postId) {

        List<CoteBoardComment> coteBoardCommentList = coteBoardCommentRepository.selectAllCoteBoardCommentUnderBoardByPostId(postId);
        List<CoteBoardCommentResponseDto> coteBoardCommentResponseDtoList = coteBoardCommentList
                .stream()
                .map(coteBoardComment -> new CoteBoardCommentResponseDto(
                coteBoardComment.getId(),
                coteBoardComment.getWriter(),
                coteBoardComment.getCommentPassword(),
                coteBoardComment.getPostId(),
                coteBoardComment.getContents(),
                coteBoardComment.getParentCommentId(),
                coteBoardComment.getCreatedAt(),
                coteBoardComment.getUpdatedAt(),
                coteBoardCommentRepository.selectAllCoteBoardReCommentUnderCommentByParentCommentId(coteBoardComment.getId())
                )).toList();
        return coteBoardCommentResponseDtoList;
    }

    @Override
    public String saveCoteBoardComment(CoteBoardCommentRequestDto CoteBoardCommentRequestDto) {
        coteBoardCommentRepository.insertCoteBoardComment(CoteBoardCommentRequestDto.toEntity());
        return null;
    }

//    @Override
//    public void saveComment(CoteBoardComment comment, long userId, String type) {
//
//        commentRepository.saveComment(comment, userId, type);
//    }

//    @Override
//    public List<CommentDto> getAllComments(long postId) {
//        return null;
//    }

//    @Override
//    public List<CommentDto> getAllComments(int id) {
//
//        commentRepository.selectAllCoteBoardCommentUnderBoardByPostId(id);
//        return null;
//    }

}
