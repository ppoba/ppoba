package com.project.ppoba.application.file.service;

import com.project.ppoba.application.file.domain.FileModel;
import com.project.ppoba.application.file.repository.FileModelRepository;
import com.project.ppoba.core.common.FileHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

@Profile("local")
@RequiredArgsConstructor
@Transactional
@Service
public class LocalServiceImpl implements FileService {
    private final String fileDir = System.getProperty("user.dir") + "/images";
    private final FileModelRepository fileModelRepository;

    @Override
    public String upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        Long size = file.getSize();
        String extension = FileHelper.extractExtension(originalFilename);

        FileModel fileModel = new FileModel(originalFilename, uuid, size, extension);
        fileModelRepository.save(fileModel);

        file.transferTo(new File(fileDir, uuid));

        return uuid;
    }

    @Override
    public Resource imgDownload(String uuid) throws MalformedURLException {
        return new UrlResource("file:" + fileDir + "/" + uuid);
    }
}
