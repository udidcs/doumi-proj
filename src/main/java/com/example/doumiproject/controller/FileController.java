package com.example.doumiproject.controller;

import com.example.doumiproject.responsedto.FileDto;
import com.example.doumiproject.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequiredArgsConstructor
public class FileController{

    private final FileService fileService;

    @PostMapping("/board/file")
    public String fileWrite(@RequestBody MultipartFile file) throws IOException {

        System.out.println(file.getOriginalFilename());

        FileDto fileDto = fileService.fileWrite(file);

        return fileDto.getFileName();
    }

    @GetMapping("/image-print")
    public byte[] printEditorImage(String fileName) {

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\quiz";

        File uploadedFile = new File(path+'\\'+fileName);

        if (uploadedFile.exists() == false) {
            throw new RuntimeException();
        }

        try {
            byte[] imageBytes = Files.readAllBytes(uploadedFile.toPath());
            return imageBytes;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
