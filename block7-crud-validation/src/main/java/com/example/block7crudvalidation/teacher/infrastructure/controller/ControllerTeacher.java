package com.example.block7crudvalidation.teacher.infrastructure.controller;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.teacher.application.TeacherService;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.example.block7crudvalidation.teacher.infrastructure.controller.dto.FullTeacherDTO;
import com.example.block7crudvalidation.teacher.infrastructure.controller.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class ControllerTeacher {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/add")
    public String addTeacher(@RequestBody Teacher teacher) {
        teacherService.createTeacher(teacher);
        return "El profesor ha sido creado";
    }

    @GetMapping("/{id}")
    public TeacherDTO readTeacherById(@PathVariable("id") String id, @RequestParam(name = "outputType", defaultValue = "simple") String type) throws EntityNotFoundException {
        Teacher teacher = teacherService.readTeacherById(id);
        if (type.equals("full")) {
            FullTeacherDTO fullTeacherDTO = new FullTeacherDTO();
            fullTeacherDTO.getFullTeacherInfo(teacher);
            return fullTeacherDTO ;
        } else {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.getTeacherSimpleInfo(teacher);
            return teacherDTO;
        }
    }

    @PutMapping("/update")
    public String modifyTeacher(@RequestBody Teacher teacher) throws EntityNotFoundException {
        teacherService.modifyTeacher(teacher);
        return "El profesor: " + teacher.getPerson().getName() + " ha sido actualizado";
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable("id") String id) throws EntityNotFoundException {
        teacherService.deleteTeacher(id);
        return "El profesor de ID: " + id + " ha sido borrado";
    }

    @GetMapping("/all")
    public List<Teacher> readEveryTeacher() {
        return teacherService.readEveryTeacher();
    }
}
