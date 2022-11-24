package com.example.block11uploaddownloadfiles.File.Infrastructure.Repository;

import com.example.block11uploaddownloadfiles.File.Domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

    //File findFileByFilename(String name);
}
