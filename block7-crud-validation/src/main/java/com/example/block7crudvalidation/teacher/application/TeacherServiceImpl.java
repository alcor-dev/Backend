package com.example.block7crudvalidation.teacher.application;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.example.block7crudvalidation.teacher.infrastructure.repository.TeacherRepository;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public Teacher readTeacherById(int id) throws EntityNotFoundException {
        return teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public String deleteTeacher(int id) {
        teacherRepository.deleteById(id);
        return "El profesor de ID: " + id + " ha sido eliminado";
    }

    @Override
    public List<Teacher> readEveryTeacher() {
        List<Teacher> allTeacher = new ArrayList<>();
        teacherRepository.findAll().forEach(teacher -> allTeacher.add(teacher));
        return allTeacher;
    }

    //Filtro para buscar dentro de la clase Teacher un id_person como el requerido
    //Lo usamos a modo de condición para poder usarlo en un IF
    @Override
    public Boolean filterByID(List<Teacher> list, int id) {
        List<Teacher> teacherResult = new ArrayList<>();
        list.stream().filter(Teacher -> Teacher.getPerson().getId_person() == id).forEach(teacher -> teacherResult.add(teacher));
        return (teacherResult.size() != 0);
    }

    //Una vez pasado el if, devolvemos el Student indicado con la ID exigida
    public Teacher getById(List<Teacher> list, int id) {
        List<Teacher> teacherRecover = new ArrayList<>();
        list.stream().filter(Teacher -> Teacher.getPerson().getId_person() == id).forEach(teacher -> teacherRecover.add(teacher));
        return teacherRecover.get(0);
    }
}