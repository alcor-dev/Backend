package com.example.block11uploaddownloadfiles.File.Application;

import com.example.block11uploaddownloadfiles.File.Domain.File;

public interface FileService {

    String createFile(File file);
    String updateFile(File file);
    File readFile(int idFile);
    void deleteFile(int idFile);
}
