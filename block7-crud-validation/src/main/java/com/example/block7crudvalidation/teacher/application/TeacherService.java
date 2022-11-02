package com.example.block7crudvalidation.teacher.application;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;

public interface TeacherService {

    String createTeacher(Teacher teacher);
    String modifyTeacher(Teacher teacher) throws EntityNotFoundException;
    Teacher readTeacherById(String id) throws EntityNotFoundException;
    String deleteTeacher(String id);
}
