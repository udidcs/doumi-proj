package com.example.doumiproject.controller;

import com.example.doumiproject.dto.*;
import com.example.doumiproject.service.QuizService;
import com.example.doumiproject.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private int pageSize = 10;

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {

        if (page < 1) {
            page = 1;
        }

        setPaginationAttributes(model, page,
                quizService.getTotalPages(pageSize), quizService.getAllQuiz(page, pageSize));

        return "quiz/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword") String keyword,
                         @RequestParam(defaultValue = "1", value = "page") int page, Model model) {

        if (page < 1) {
            page = 1;
        }

        setPaginationAttributes(model, page,
                quizService.getTotalPages(pageSize, keyword), quizService.getSearchQuiz(keyword, page, pageSize));
        model.addAttribute("keyword", keyword);

        return "quiz/search";
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

    @GetMapping("/board")
    public String getQuizDetail(@RequestParam("id") Long id, Model model){
        //글의 상세 정보 가져오기
        QuizDto quizDetail=quizService.getQuizDetail(id);
        //글에 연결된 태그들 가져오기
        List<TagDetailDto> tags=quizService.getTags(id);
        //글에 연결된 댓글들 가져오기
        List<CommentDto> comments=quizService.getComments(id);
        model.addAttribute("quiz",quizDetail);
        model.addAttribute("tags",tags);
        model.addAttribute("comments",comments);
        return "quiz/board";
    }

    @GetMapping("/post")
    public String createQuiz(Model model){
        //타입별 태그 모두 불러오기
        List<TagDto> tags = quizService.getAllTags();
        model.addAttribute("tags",tags);
        model.addAttribute("QuizVO",new QuizVO());
        return "quiz/form";
    }

    @PostMapping("/post")
    public ResponseEntity<String> postQuiz(QuizVO quizVO) {
        Long postId = quizService.saveQuiz(quizVO, 1l);
        return ResponseEntity.ok("/quiz/board?id="+postId);
    }

    @GetMapping("/edit")
    public String editQuiz(@RequestParam("id") Long id, Model model){
        //로그인 생기면 현재 로그인된 유저의 nickname과 quizDetail의 userId가 일치한지 검증 필요
        QuizDto quizDetail=quizService.getQuizDetail(id);
        List<TagDetailDto> selectedTags=quizService.getTags(id);
        List<TagDto> tags = quizService.getAllTags();
        model.addAttribute("quiz",quizDetail);
        model.addAttribute("selectedTags",selectedTags);
        model.addAttribute("tags",tags);
        return "quiz/edit";
    }

    @PostMapping("/edit")
    public ResponseEntity<String> updateQuiz(@RequestParam("id") Long id, QuizVO quizVO){
        //수정 권한있는 사용자인지 검증 로직 repository에 수정필요
        quizService.updateQuiz(quizVO, id, 1l);
        return ResponseEntity.ok("/quiz/board?id="+id);
    }

    @DeleteMapping("/delete")
    public String deleteQuiz(@RequestParam("id") long id){
        quizService.deleteQuiz(id);
        return "redirect:/quiz";
    }
}
