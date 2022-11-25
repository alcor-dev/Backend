package com.example.block11uploaddownloadfiles.File.Application;

import com.example.block11uploaddownloadfiles.File.Domain.File;

import java.util.List;

public interface FileService {

    String createFile(File file);
    String updateFile(File file);
    File readFile(int idFile);
    File readFileByName(String name);
    List<File> readAllFiles();
    void deleteFile(int idFile);
}
