package com.example.block7crudvalidation.feign;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.example.block7crudvalidation.teacher.infrastructure.controller.dto.TeacherDTO;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "FeignServer", url = "http://localhost:8081")
public interface FeignServer {

    @GetMapping("/teacher/{id}")
    TeacherDTO readTeacherById(@PathVariable("id") int id);
}
