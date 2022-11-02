package com.example.block7crudvalidation.person.infrastructure.controller;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.person.application.PersonServiceImpl;
import com.example.block7crudvalidation.person.infrastructure.controller.dto.PersonDTO;
import com.example.block7crudvalidation.person.infrastructure.controller.dto.StudentPersonDTO;
import com.example.block7crudvalidation.person.infrastructure.controller.dto.TeacherPersonDTO;
import com.example.block7crudvalidation.student.application.StudentServiceImpl;
import com.example.block7crudvalidation.teacher.application.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ControllerPerson {

    @Autowired
    PersonServiceImpl personService;

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    TeacherServiceImpl teacherService;

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person) throws Exception {
        if(person.checkData()) {
            personService.createPerson(person);
            return "Añadida persona: " + person.getName().toUpperCase();
        } else {
            throw new UnprocessableEntityException();
        }
    }

    @GetMapping("/id/{id}")
    public PersonDTO readPersonById(@PathVariable("id") String id, @RequestParam(name = "outputType", defaultValue = "simple") String type ) throws EntityNotFoundException {
        Person person = personService.readPersonById(id);

        if (type.equals("full") && (person.getId_person() == studentService.readStudentById(id).getId_student())) {
            StudentPersonDTO personStudentDTO = new StudentPersonDTO();
            personStudentDTO.getStudentPersonInfo(studentService.readStudentById(id));
            return personStudentDTO;

        } else if (type.equals("full") &&(person.getId_person() == teacherService.readTeacherById(id).getId_teacher())) {
            TeacherPersonDTO teacherPersonDTO = new TeacherPersonDTO();
            teacherPersonDTO.getTeacherPersonInfo(teacherService.readTeacherById(id));
            return teacherPersonDTO;

        } else {
            PersonDTO personDTO = new PersonDTO();
            personDTO.getPersonInfo(person);
            return personDTO;
        }
    }

    @GetMapping("/name/{name}")
    public Person readPersonByName(@PathVariable("name") String name) throws EntityNotFoundException{
        return personService.readPersonByName(name);
    }

    @GetMapping("/all")
    public List<Person> readAllPerson() {
        return personService.readEveryPerson();
    }

    @PutMapping("/update")
    public String updatePerson(@RequestBody Person person) throws Exception {
        if (person.checkData()){
            personService.updatePerson(person);
            return "La persona: " + person.getName() + " ha sido actualizada";
        } else {
            throw new UnprocessableEntityException();
        }
    }
}