package com.example.block7crudvalidation.feign;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "FeignServer", url = "http://localhost:8081/")
public interface FeignServer {

    @RequestMapping(method = RequestMethod.GET, value = "/teacher/{id}")
    public Teacher findTeacherById(@PathVariable("id") String id);
}
