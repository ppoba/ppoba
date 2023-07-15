package com.project.ppoba.application.file.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

@Profile("prod")
@RequiredArgsConstructor
@Transactional
@Service
public class S3ServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile file) throws IOException {
        System.out.println("1");
        return null;
    }

    @Override
    public Resource imgDownload(String uuid) throws MalformedURLException {
        System.out.println("2");
        return null;
    }
}
