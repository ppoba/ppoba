package com.project.ppoba.application.file.controller;

import com.project.ppoba.application.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

@RequiredArgsConstructor
@RestController
public class FileController {

    private final FileService fileService;

    @PostMapping("/file/upload")
    public String fileUpload(@RequestPart  MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) throw new RuntimeException();

        return fileService.upload(file);
    }
    @GetMapping("/file/original/{uuid}")
    public ResponseEntity<Resource> fileDownload(@PathVariable String uuid) throws MalformedURLException {
        if (StringUtils.isBlank(uuid)) throw new RuntimeException();

        Resource resource = fileService.imgDownload(uuid);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("image/png"))
                .body(resource);
    }


    @GetMapping("/file/thumbnail/{uuid}")
    public void thumbnail(@PathVariable String uuid) {

    }

}
