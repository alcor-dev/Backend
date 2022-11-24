package com.example.block11uploaddownloadfiles.File.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class File implements Serializable {

    public File(String name, MultipartFile data) throws IOException {
        this.filename = name;
        this.data = data.getBytes();
        addDate();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fileId;

    @Column
    private String filename;

    @Column
    private Date uploadDate;

    @Lob
    private byte[] data;

    public void addDate(){
        Calendar actualCalendar = Calendar.getInstance();
        Date uploadDate = actualCalendar.getTime();
        this.setUploadDate(uploadDate);
    }

}
