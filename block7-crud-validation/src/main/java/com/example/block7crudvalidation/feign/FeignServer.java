package com.example.block7crudvalidation.feign;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.example.block7crudvalidation.teacher.infrastructure.controller.dto.TeacherDTO;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.web.bind.annotation.*;

@FeignClient(name = "FeignServer", url = "http://localhost:8081")
public interface FeignServer {

    //@RequestMapping(method = RequestMethod.GET, value = "/teacher/{id}")
    @GetMapping("/teacher/{id}")
    Teacher readTeacherById(@PathVariable("id") int id);
}
