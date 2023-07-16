package com.project.ppoba.core.common;

public class FileHelper {
    public static String extractExtension(String originFileName) {
        int pos = originFileName.lastIndexOf(".");
        return originFileName.substring(pos + 1);
    }
}
