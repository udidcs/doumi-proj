package com.example.doumiproject.controller;

import com.example.doumiproject.entity.CoteBoardComment;
import com.example.doumiproject.exception.coteboard.CoteBoardAccessDeniedException;
import com.example.doumiproject.requestdto.CoteBoardLoginRequestDto;
import com.example.doumiproject.requestdto.CoteBoardRequestDto;
import com.example.doumiproject.responsedto.*;
import com.example.doumiproject.service.CoteBoardCommentService;
import com.example.doumiproject.service.CoteBoardService;
import com.example.doumiproject.service.UserService;
import com.example.doumiproject.staticvalue.coteBoard.CoteBoardStatic;
import com.example.doumiproject.util.PaginationUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CoteBoardController {

    private final CoteBoardService coteBoardService;
    private final CoteBoardCommentService commentService;
    private final UserService userService;

    @GetMapping("/coteboard")
    public String coteboard(@RequestParam(defaultValue = "1") int page, Model model) {

        if (page < 1) {
            page = 1;
        }

        setPaginationAttributes(model, page,
                coteBoardService.getTotalPages(CoteBoardStatic.PAGESIZE), coteBoardService.getAllCoteBoards(page, CoteBoardStatic.PAGESIZE));

        return "coteboard/board";
    }

    @GetMapping("/coteboard/search")
    public String search(@RequestParam(value = "keyword") String keyword,
                         @RequestParam(defaultValue = "1", value = "page") int page, Model model) {

        if (page < 1) {
            page = 1;
        }

        setPaginationAttributes(model, page,
                coteBoardService.getTotalPages(CoteBoardStatic.PAGESIZE, keyword), coteBoardService.getAllCoteBoards(page, CoteBoardStatic.PAGESIZE, keyword));
        model.addAttribute("keyword", keyword);

        return "coteboard/board";
    }

//    @GetMapping("/tag")
//    public String searchTags(@RequestParam(value = "name") String tag,
//                             @RequestParam(defaultValue = "1", value = "page") int page, Model model) {
//
//        if (page < 1) {
//            page = 1;
//        }
//
//        setPaginationAttributes(model, page,
//                quizService.getTotalPagesForSelectedTag(pageSize, tag),
//                quizService.getQuizForSelectedTag(tag, page, pageSize));
//        model.addAttribute("tag", tag);
//
//        return "cote/tag";
//    }

    private void setPaginationAttributes(Model model, int page, int totalPages, List<CoteBoardResponseDto> list) {

        int startIdx = PaginationUtil.calculateStartIndex(page);
        int endIdx = PaginationUtil.calculateEndIndex(page, totalPages);

        model.addAttribute("cotes", list);
        model.addAttribute("currentPage", page);
        model.addAttribute("startIdx", startIdx);
        model.addAttribute("endIdx", endIdx);
        model.addAttribute("totalPages", totalPages);
    }

    @GetMapping("/coteboard/detail")
    public String detail(@RequestParam("id") int postId, Model model){

        CoteBoardResponseDto coteBoardResponseDto = coteBoardService.getCoteBoard(postId);
        List<CoteBoardCommentResponseDto> coteBoardCommentResponseDtoList = commentService.getAllCoteBoardComments(postId);

        //저장한 댓글 가져오기
        model.addAttribute("cote", coteBoardResponseDto);
        model.addAttribute("postId", postId);
        model.addAttribute("comments", coteBoardCommentResponseDtoList);

        CoteBoardComment coteBoardComment = new CoteBoardComment();
        coteBoardComment.setWriter("김이");

        model.addAttribute("newComment", coteBoardComment);

        return "coteboard/detail";
    }

    @GetMapping("/coteboard/form")
    public String form() {
        return "coteboard/form";
    }

    @PostMapping("/coteboard/form")
    public ResponseEntity<String> form_post(CoteBoardRequestDto coteBoardRequestDto, HttpServletRequest req) {

        UserDto user = userService.getUser(1);

        if (coteBoardRequestDto.getUserPassword() != null && coteBoardRequestDto.getUserPassword().equals(user.getUserPassword())) {
            int postId = coteBoardService.saveCoteBoard(coteBoardRequestDto);
            return ResponseEntity.ok("/coteboard/detail?id="+postId);
        }
        throw new CoteBoardAccessDeniedException();
    }
//
//    @GetMapping("/edit")
//    public String editQuiz(@RequestParam("id") Long id, Model model){
//
//        //로그인 생기면 현재 로그인된 유저의 nickname과 quizDetail의 userId가 일치한지 검증 필요
//        QuizDto quiz=quizService.getQuiz(id);
//        List<TagDto> tags = quizService.getAllTags();
//
//        model.addAttribute("quiz",quiz);
//        model.addAttribute("tags",tags);
//
//        return "cote/edit";
//    }
//
//    @PostMapping("/edit")
//    public ResponseEntity<String> updateQuiz(@RequestParam("id") Long id, Quiz quiz){
//
//        //수정 권한있는 사용자인지 검증 로직 repository에 수정필요
//        quizService.updateQuiz(quiz, id, 1l);
//
//        return ResponseEntity.ok("/cote/board?id="+id);
//    }
//
//    @DeleteMapping("/delete")
//    public String deleteQuiz(@RequestParam("id") long id){
//
//        quizService.deleteQuiz(id);
//
//        return "redirect:/cote";
//    }
}
