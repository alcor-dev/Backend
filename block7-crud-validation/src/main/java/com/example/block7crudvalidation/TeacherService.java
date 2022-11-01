package com.example.block7crudvalidation;

public interface TeacherService {

    String createTeacher(Teacher teacher);
    String modifyTeacher(Teacher teacher) throws EntityNotFoundException;
    Teacher readTeacherById(String id) throws EntityNotFoundException;
    String deleteTeacher(String id);
}
