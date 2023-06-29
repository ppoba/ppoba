package com.project.ppoba.application.file.repository;

import com.project.ppoba.application.file.domain.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileModelRepository extends JpaRepository<FileModel, Long> {
}
