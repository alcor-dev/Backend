package com.example.block11uploaddownloadfiles.File.Infrastructure.Controller;

import com.example.block11uploaddownloadfiles.File.Application.FileServiceImpl;
import com.example.block11uploaddownloadfiles.File.Domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
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
    ApplicationArguments applicationArguments;

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
        //Here we will get the list of the non optional arguments
        List<String> pathArgs = applicationArguments.getNonOptionArgs();
        String pathDownload = "downloads/";
        System.out.println("PathArgs size is : " + pathArgs.size());

        //If there isn't any non optional argument then the list size should be zero
        //If not it will be greater than zero and then the path will be changed
        if (pathArgs.size() > 0){
            pathDownload = pathArgs.get(0);
        }
        File recoveredFile = fileService.readFile(fileId);
        //Here we can use some concatenation to mix the name of the file and the path we wish to use
        Path path = Paths.get(pathDownload + recoveredFile.getFilename());
        if (Files.exists(path)) {
            //If the path already exists, then it will go and write over the directory
            Files.write(path, recoveredFile.getData());
            System.out.println("File has been written successfully");
        } else {
            //In case the path isn't created it will be so gentle it'll do so for us and then write the file
            //How courteous of the program, to be so well educated *takes a sip of tea*
            Files.createDirectories(Paths.get(pathDownload));
            Files.write(path, recoveredFile.getData());
            System.out.println("File has been written successfully");
        }

    }

    @GetMapping("/download/name/{name}")
    public void downloadFileName(@PathVariable("name") String name) throws IOException {
        //Here we will get the list of the non optional arguments
        List<String> pathArgs = applicationArguments.getNonOptionArgs();
        String pathDownload = "downloads/";
        System.out.println("PathArgs size is : " + pathArgs.size());

        //If there isn't any non optional argument then the list size should be zero
        //If not it will be greater than zero and then the path will be changed
        if (pathArgs.size() > 0){
            pathDownload = pathArgs.get(0);
        }
        File recoveredFile = fileService.readFileByName(name);
        //Here we can use some concatenation to mix the name of the file and the path we wish to use
        Path path = Paths.get(pathDownload + recoveredFile.getFilename());
        if (Files.exists(path)) {
            //If the path already exists, then it will go and write over the directory
            Files.write(path, recoveredFile.getData());
            System.out.println("File has been written successfully");
        } else {
            //In case the path isn't created it will be so gentle it'll do so for us and then write the file
            //How courteous of the program, to be so well educated *takes a sip of tea*
            Files.createDirectories(Paths.get(pathDownload));
            Files.write(path, recoveredFile.getData());
            System.out.println("File has been written successfully");
        }
    }

    @GetMapping("/read/all")
    public List<File> readAllData(){
        List<File> listReturn = fileService.readAllFiles();
        return listReturn;
    }


}
