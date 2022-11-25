package com.example.block11uploaddownloadfiles.File.Infrastructure.Controller;

import com.example.block11uploaddownloadfiles.File.Application.FileServiceImpl;
import com.example.block11uploaddownloadfiles.File.Domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping
public class FileController {

    @Autowired
    FileServiceImpl fileService;

    //This method here will help us by uploading our files and all the data related to it (AKA metadata)
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadFile(@RequestPart MultipartFile image) throws IOException {
        File file = new File();
        file.addDate();
        file.setFilename(image.getOriginalFilename());
        file.setData(image.getBytes());
        file.setType(image.getContentType());
        fileService.createFile(file);
    }

    //This method here will allow us to read the file which ID has been specified before
    @GetMapping("/read/{id}")
    public File downloadFile(@PathVariable("id") int fileId) throws NoSuchFileException {
         return fileService.readFile(fileId);
    }

    @GetMapping("/download/id/{id}")
    public void downloadFileId(@PathVariable("id") int fileId) throws IOException {
        String pathDownload = "downloads/";
        File recoveredFile = fileService.readFile(fileId);
        Path path = Paths.get(pathDownload + recoveredFile.getFilename());
        Files.write(path, recoveredFile.getData());
        System.out.println("File has been written successfully");
    }

    @GetMapping("/download/name/{name}")
    public void downloadFileName(@PathVariable("name") String name) throws IOException {
        String pathDownload = "downloads/";
        File recoveredFile = fileService.readFileByName(name);
        Path path = Paths.get(pathDownload + recoveredFile.getFilename());
        Files.write(path, recoveredFile.getData());
        System.out.println("File has been written successfully");
    }

    @GetMapping("/read/all")
    public List<File> readAllData(){
        List<File> listReturn = fileService.readAllFiles();
        return listReturn;
    }


}
