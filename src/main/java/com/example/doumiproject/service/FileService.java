package com.example.doumiproject.service;


import com.example.doumiproject.responsedto.FileDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    public FileDto fileWrite(MultipartFile file) throws IOException;
}
