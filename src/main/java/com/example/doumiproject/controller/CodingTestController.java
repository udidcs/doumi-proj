//package com.example.doumiproject.controller;
//
//import com.example.doumiproject.responsedto.CoteDto;
//import com.example.doumiproject.responsedto.PostDto;
//import com.example.doumiproject.responsedto.TagDto;
//import com.example.doumiproject.entity.Cote;
//import com.example.doumiproject.service.CoteService;
//import com.example.doumiproject.util.PaginationUtil;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class CodingTestController {
//
//    private final CoteService coteService;
//    private int pageSize = 10;
//    @GetMapping("/doumiAlgorithm")
//    public String index() {
//
//        return "codingtest/doumiAlgorithm";
//    }
//
//    @GetMapping("/board")
//    public String getCoteDetail(@RequestParam("id") Long id, Model model){
//
//
//        //글의 상세 정보 가져오기
//        CoteDto quiz = coteService.getCote(id);
//        //글에 연결된 댓글들 가져오기
//
//
//        model.addAttribute("quiz",quiz);
//        model.addAttribute("postId", quiz.getId());
////        model.addAttribute("comments",comments);
////        model.addAttribute("newComment",new Comment());
//
//        return "quiz/board";
//    }
//    @GetMapping("/codingtest/timecomplexity")
//    public String timecomplexity() {
//
//        return "codingtest/timecomplexity";
//    }
//
//    @GetMapping("/codingtest/post")
//    public String createQuiz(Model model){
//
//        //타입별 태그 모두 불러오기
//        List<TagDto> tags = coteService.getAllTags();
//
//        model.addAttribute("tags",tags);
//        model.addAttribute("quiz",new Quiz());
//
//        return "codingtest/form";
//    }
//    @PostMapping("/codingtest/post")
//    public ResponseEntity<String> postCote(Cote quiz) {
//
//        Long postId = coteService.saveCote(quiz, 1l);
//
//        return ResponseEntity.ok("/codingtest/board?id="+postId);
//    }
//
//    @GetMapping("/edit")
//    public String editQuiz(@RequestParam("id") Long id, Model model){
//
//        //로그인 생기면 현재 로그인된 유저의 nickname과 quizDetail의 userId가 일치한지 검증 필요
//        CoteDto quiz=coteService.getCote(id);
//
//        model.addAttribute("quiz",quiz);
//
//        return "codingtest/edit";
//    }
//
//    @PostMapping("/edit")
//    public ResponseEntity<String> updateQuiz(@RequestParam("id") Long id, Cote quiz){
//
//        //수정 권한있는 사용자인지 검증 로직 repository에 수정필요
//        coteService.updateCote(quiz, id, 1l);
//
//        return ResponseEntity.ok("/codingtest/board?id="+id);
//    }
//
//    @DeleteMapping("/delete")
//    public String deleteQuiz(@RequestParam("id") long id){
//
//        coteService.deleteCote(id);
//
//        return "redirect:/doumiAlgorithm";
//    }
//    private void setPaginationAttributes(Model model, int page, int totalPages, List<PostDto> cotes) {
//
//        int startIdx = PaginationUtil.calculateStartIndex(page);
//        int endIdx = PaginationUtil.calculateEndIndex(page, totalPages);
//
//        model.addAttribute("cotes", cotes);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("startIdx", startIdx);
//        model.addAttribute("endIdx", endIdx);
//        model.addAttribute("totalPages", totalPages);
//    }
//
//}
