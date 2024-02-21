package com.example.doumiproject.service;

import com.example.doumiproject.dto.FileDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@NoArgsConstructor
public class FileServiceImpl implements FileService{

    @Override
    public FileDto fileWrite(MultipartFile file) throws IOException {

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\quiz";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File savefile = new File(path, fileName);

        file.transferTo(savefile);

        FileDto fileDto = new FileDto("id", fileName, "");

        return fileDto;
    }
}
