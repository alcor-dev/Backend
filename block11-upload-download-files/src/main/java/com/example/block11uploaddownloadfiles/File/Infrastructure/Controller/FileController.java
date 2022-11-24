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

import java.io.IOException;
import java.nio.file.NoSuchFileException;

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
        fileService.createFile(file);
    }

    //This method here will allow us to read the file which ID has been specified before
    @GetMapping("/read/{id}")
    public File downloadFile(@PathVariable("id") int fileId) throws NoSuchFileException {
         return fileService.readFile(fileId);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity downloadFileId(@PathVariable("id") int fileId) {
        File file = fileService.readFile(fileId);
        if (file != null) {
            return ResponseEntity.ok().contentType(MediaType.parseMediaType("multipart/form-data"))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + file.getFilename())
                    .body(new ByteArrayResource(file.getData()));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No file was found with id: " + fileId);
        }

    }
}
