package com.example.block17batch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class csv implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        //"block17-batch/src/main/resources/people.csv"
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/people.csv",
                true));
        int i = 1;
        while(i<=1000){
            writer.append("name"+i+",surname"+i+"\n");
            i++;
        }

        writer.close();
    }
}
