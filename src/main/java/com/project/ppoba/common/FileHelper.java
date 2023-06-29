package com.project.ppoba.common;

public class FileHelper {
    public static String extractExtension(String originFileName) {
        int pos = originFileName.lastIndexOf(".");
        return originFileName.substring(pos + 1);
    }
}
