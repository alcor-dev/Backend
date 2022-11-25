package com.example.block11uploaddownloadfiles.File.Application;

import com.example.block11uploaddownloadfiles.File.Domain.File;
import com.example.block11uploaddownloadfiles.File.Infrastructure.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    FileRepository fileRepository;

    @Override
    public String createFile(File file) {

        //We add the time when the file was uploaded right before saving it into the database
        //Nobody likes dealing with dates
        fileRepository.save(file);
        return "El archivo: " + file.getFilename() + " ha sido guardado";
    }

    @Override
    public String updateFile(File file) {
        fileRepository.save(file);
        return "El archivo: " + file.getFileId() + " ha sido actualizado";
    }

    @Override
    public File readFile(int idFile) {
        return fileRepository.findById(idFile).orElseThrow(() -> new EntityNotFoundException() );
    }

    @Override
    public File readFileByName(String name) {
        return fileRepository.findByFilename(name);
    }

    @Override
    public List<File> readAllFiles() {
        List<File> fileList = fileRepository.findAll();
        return fileList;
        //return fileRepository.findAll();
    }

    @Override
    public void deleteFile(int idFile) {
        fileRepository.deleteById(idFile);
    }
}
