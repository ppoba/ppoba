package com.project.ppoba.application.file.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public interface FileService {

    //TODO image Resize
    String upload(MultipartFile file) throws IOException;

    Resource imgDownload(String uuid) throws MalformedURLException;

    //TODO preview
}
