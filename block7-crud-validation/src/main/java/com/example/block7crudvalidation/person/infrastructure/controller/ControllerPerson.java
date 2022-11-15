package com.example.block7crudvalidation.person.infrastructure.controller;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.feign.FeignServer;
import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.person.application.PersonServiceImpl;
import com.example.block7crudvalidation.person.infrastructure.controller.dto.PersonDTO;
import com.example.block7crudvalidation.person.infrastructure.controller.dto.StudentPersonDTO;
import com.example.block7crudvalidation.person.infrastructure.controller.dto.TeacherPersonDTO;
import com.example.block7crudvalidation.student.application.StudentServiceImpl;
import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.teacher.application.TeacherServiceImpl;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.example.block7crudvalidation.teacher.infrastructure.controller.dto.TeacherDTO;
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

    @Autowired
    FeignServer feignServer;

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person) throws Exception {
        if(person.checkData()) {
            personService.createPerson(person);
            return "Añadida persona: " + person.getName().toUpperCase();
        } else {
            throw new UnprocessableEntityException();
        }
    }

     @PostMapping("/list")
     public void addList(@RequestBody List<Person> personList) {
        System.out.println("Añadiendo " + personList.size() + " personas");
        personList.stream().forEach(person -> personService.createPerson(person));
     }

    //Filtro para mostrar datos según el tipo de dato que llegue y si está asociado a profesor o a alumno
    @GetMapping("/id/{id}")
    public PersonDTO readPersonById(@PathVariable("id") int id, @RequestParam(name = "outputType", defaultValue = "simple") String type ) throws EntityNotFoundException {

        if (type.equals("full")) {

            List<Student> listStudent = studentService.readEveryStudent();
            List<Teacher> listTeacher = teacherService.readEveryTeacher();

            //Si la id_person está dentro de alguien de la clase Student entonces...
            if (studentService.filterByID(listStudent, id)) {
                StudentPersonDTO studentPersonDTO = new StudentPersonDTO();
                Student student = new Student();
                student = studentService.getById(listStudent, id);
                studentPersonDTO.getStudentPersonInfo(student);
                return studentPersonDTO;

            //Si la id_person está dentro de alguien de la clase Teacher entonces...
            } else if (teacherService.filterByID(listTeacher, id)) {
                TeacherPersonDTO teacherPersonDTO = new TeacherPersonDTO();
                Teacher teacher = new Teacher();
                teacher = teacherService.getById(listTeacher, id);
                teacherPersonDTO.getTeacherPersonInfo(teacher);
                return teacherPersonDTO;

            //Si la id_person no está en ninguna de las otras clases, entonces devuelve un Person
            } else {
                PersonDTO personDTO = new PersonDTO();
                personDTO.getPersonInfo(personService.readPersonById(id));
                return personDTO;
            }

        } else {

            PersonDTO personDTO = new PersonDTO();
            personDTO.getPersonInfo(personService.readPersonById(id));
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

    //Feign
    @GetMapping("/teacher/{id}")
    public Teacher readTeacherById(@PathVariable("id") int id, @RequestParam(name = "outputType", defaultValue = "simple") String type){
        return feignServer.readTeacherById(id);
    }
}