package com.example.doumiproject.api;

import com.example.doumiproject.dto.CommentDto;
import com.example.doumiproject.dto.PostDto;
import com.example.doumiproject.dto.QuizDto;
import com.example.doumiproject.dto.TagDto;
import com.example.doumiproject.entity.Quiz;
import com.example.doumiproject.exception.PageNegativeValueException;
import com.example.doumiproject.service.QuizService;
import com.example.doumiproject.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiQuizController {

    private final QuizService quizService;
    private int pageSize = 10;

    @GetMapping("/api/quiz/search")
    public ResponseEntity<ApiQuizResponseDto> search(@RequestParam(value = "keyword") String keyword,
                         @RequestParam(defaultValue = "1", value = "page") int page, Model model) throws RuntimeException {

        if (page < 1) {
            throw new PageNegativeValueException();
        }

        ApiQuizResponseDto dto = new ApiQuizResponseDto();
        dto.setPage(page);
        dto.setTotalpage(quizService.getTotalPages(pageSize, keyword));
        dto.setLst(quizService.getSearchQuiz(keyword, page, pageSize));
        return ResponseEntity.ok(dto);
    }

    private void setPaginationAttributes(Model model, int page, int totalPages, List<PostDto> quizs) {

        int startIdx = PaginationUtil.calculateStartIndex(page);
        int endIdx = PaginationUtil.calculateEndIndex(page, totalPages);

        model.addAttribute("quizs", quizs);
        model.addAttribute("currentPage", page);
        model.addAttribute("startIdx", startIdx);
        model.addAttribute("endIdx", endIdx);
        model.addAttribute("totalPages", totalPages);
    }
}
