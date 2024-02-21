package com.example.doumiproject.controller;

import com.example.doumiproject.dto.FileDto;
import com.example.doumiproject.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileController{

    private final FileService fileService;

    @PostMapping("/board/file")
    public ResponseEntity<?> fileWrite(Model model, MultipartFile file) throws IOException {

        System.out.println(file.getOriginalFilename());

        FileDto fileDto = fileService.fileWrite(file);

        return new ResponseEntity<>(fileDto, HttpStatus.OK);
    }
}
