package com.project.ppoba.application.file.domain;

import com.project.ppoba.core.common.BaseEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Entity
public class FileModel extends BaseEntity {
    public String uuid;
    public String originFileName;
    public Long size;
    public String extension;

    public FileModel(String originalFilename, String uuid, Long size, String extension) {
        super();
        this.originFileName = originalFilename;
        this.uuid = uuid;
        this.size = size;
        this.extension = extension;
    }
}
