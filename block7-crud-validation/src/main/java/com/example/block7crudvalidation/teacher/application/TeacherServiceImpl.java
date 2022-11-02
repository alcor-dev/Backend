package com.example.block7crudvalidation.teacher.application;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.example.block7crudvalidation.teacher.infrastructure.repository.TeacherRepository;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public String createTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return "El profesor ha sido creado";
    }

    @Override
    public String modifyTeacher(Teacher teacher) throws EntityNotFoundException {
        teacherRepository.save(teacher);
        return "El profesor" + teacher.getPerson().getName() + "ha sido modificado";
    }

    @Override
    public Teacher readTeacherById(String id) throws EntityNotFoundException {
        return teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public String deleteTeacher(String id) {
        teacherRepository.deleteById(id);
        return "El profesor de ID: " + id + " ha sido eliminado";
    }
}
