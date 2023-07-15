package com.project.ppoba.application.file.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Profile("prod")
@RequiredArgsConstructor
@Transactional
@Service
public class S3ServiceImpl implements FileService {
    private final S3Client s3Client;

    @Value("${aws.s3.bucket}")
    private String bucket;

    @Value("${aws.s3.path}")
    private String path;

    @Override
    public String upload(MultipartFile file) throws IOException {
        String uuid = UUID.randomUUID().toString();
        PutObjectRequest putObj = PutObjectRequest.builder()
                .bucket(bucket)
                .key(path + uuid)
                .build();

        s3Client.putObject(putObj, RequestBody.fromBytes(file.getBytes()));
        return uuid;
    }

    @Override
    public Resource imgDownload(String uuid) throws MalformedURLException {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucket)
                .key(path + uuid)
                .build();

        byte[] file = s3Client.getObjectAsBytes(getObjectRequest).asByteArray();
        return new ByteArrayResource(file);
    }

}
