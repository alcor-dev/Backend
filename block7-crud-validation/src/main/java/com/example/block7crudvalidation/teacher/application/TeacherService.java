package com.example.block7crudvalidation.teacher.application;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;

import java.util.List;

public interface TeacherService {

    String createTeacher(Teacher teacher);
    String modifyTeacher(Teacher teacher) throws EntityNotFoundException;
    Teacher readTeacherById(int id) throws EntityNotFoundException;
    String deleteTeacher(int id);
    List<Teacher> readEveryTeacher();
    Boolean filterByID(List<Teacher> list, int id);
}
