package com.example.doumiproject.service;


import com.example.doumiproject.entity.CoteBoard;
import com.example.doumiproject.repository.CoteBoardRepository;
import com.example.doumiproject.responsedto.CoteBoardDto;
import com.example.doumiproject.staticvalue.coteBoard.CoteBoardStatic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class CoteBoardServiceImpl implements CoteBoardService{
    private final CoteBoardRepository coteBoardRepository;

    @Override
    public List<CoteBoardDto> getAllCoteBoards(int page, int pageSize) {
        AtomicInteger boardNum = new AtomicInteger((page-1)*CoteBoardStatic.PAGESIZE+1);
        List<CoteBoardDto> list = coteBoardRepository.selectAllCoteBaords(page, pageSize).stream()
                .map(coteBoard -> new CoteBoardDto(boardNum.getAndIncrement(), coteBoard.getId(), coteBoard.getUser_id(),
                coteBoard.getTitle(), coteBoard.getContents(), coteBoard.getView_count())).toList();
        return list;
    }

    @Override
    public List<CoteBoardDto> getAllCoteBoards(int page, int pageSize, String keyword) {
        AtomicInteger boardNum = new AtomicInteger((page-1)*CoteBoardStatic.PAGESIZE+1);
        List<CoteBoardDto> list = coteBoardRepository.selectAllCoteBaords(page, pageSize, keyword).stream()
                .map(coteBoard -> new CoteBoardDto(boardNum.getAndIncrement(), coteBoard.getId(), coteBoard.getUser_id(),
                        coteBoard.getTitle(), coteBoard.getContents(), coteBoard.getView_count())).toList();
        return list;
    }

    @Override
    public int getTotalPages(int pageSize) {
        return coteBoardRepository.selectTotalPages(pageSize);
    }

    @Override
    public int getTotalPages(int pageSize, String keyword) {
        return coteBoardRepository.selectTotalPages(pageSize, keyword);
    }

    @Override
    public CoteBoardDto getCoteBoard(long postId) {
        AtomicInteger boardNum = new AtomicInteger();
        CoteBoard coteBoard = coteBoardRepository.selectCoteBoardById(postId);
        return new CoteBoardDto(boardNum.getAndIncrement(), coteBoard.getId(), coteBoard.getUser_id(),
                coteBoard.getTitle(), coteBoard.getContents(), coteBoard.getView_count());
    }
//
//    @Override
//    public List<PostDto> getAllQuiz() {
//
//        return postRepository.findAllQuiz();
//    }
//
//    @Override
//    public int getTotalPages(int pageSize) {
//
//        return postRepository.getTotalPages(pageSize);
//    }
//
//    @Override
//    public CoteDto getQuiz(long postId){
//
//        return coteBoardRepository.getByCoteBoardId(postId);
//    }

//    데이터 저장 도중 에러가 생길 경우 원 상태로 복귀
//    @Transactional
//    @Override
//    public Long saveQuiz(Quiz quiz, Long userId) {
//
//        return quizRepository.saveQuiz(quiz, userId);
//    }
//
//    @Override
//    public int getTotalPages(int pageSize, String keyword) {
//
//        return postRepository.getTotalPages(pageSize, keyword);
//    }
//
//    @Override
//    public List<PostDto> getSearchQuiz(String keyword, int page, int pageSize) {
//
//        return postRepository.findByTitleOrAuthor(keyword, page, pageSize);
//    }
//
//    @Transactional
//    @Override
//    public void updateQuiz(Quiz quiz, Long postId, Long userId) {
//
//        quizRepository.updateQuiz(quiz, postId, userId);
//    }
//
//    @Override
//    public void deleteQuiz(long postId) {
//
//        quizRepository.deleteQuiz(postId);
//    }



}
