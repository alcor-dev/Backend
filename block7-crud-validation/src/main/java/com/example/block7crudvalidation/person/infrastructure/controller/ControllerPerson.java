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
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    @PersistenceContext
    EntityManager entityManager;


    //La etiqueta @CrossOrigin nos permite que se acepten conexiones desde una dirección o direcciones que le son
    //especificadas dentro de esta, así pues, podemos controlar el acceso externo desde varios puntos como, por
    //endpoints individuales, clases, programas enteros...
    @CrossOrigin(origins = "https://cdpn.io")
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

     @DeleteMapping("/delete/{id}")
     public String deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
        return "La persona con ID: " + id + " ha sido eliminada";
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

    @CrossOrigin(origins = "https://cdpn.io")
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
    public TeacherDTO readTeacherById(@PathVariable("id") int id, @RequestParam(name = "outputType", defaultValue = "simple") String type){
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.getTeacherSimpleInfo(feignServer.readTeacherById(id));
        return teacherDTO;
    }

    //Filtering done with CriteriaBuilder
    //All hail the mighty HashMap... PRAISE THE SUN!
    @GetMapping("/filter")
    public List<Person> filterPersonByParams(@RequestParam(value = "order", required = false) String order, @RequestParam HashMap<String, String> conditions){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = query.from(Person.class);

        //Little check so we know what values do we have inside our variable
        conditions.forEach((field,value) -> System.out.println(field + " = " + value));

        //We add the predicates here, so they can add up to each other and then act as a filter
        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach( (field, value) -> {
            switch(field) {
                case "username", "name", "surname":
                    predicates.add(criteriaBuilder.like(personRoot.get(field),"%" + (String) value + "%"));
                    break;
                case "dateGT":
                    try {
                        predicates.add(criteriaBuilder.greaterThan(personRoot.get("created_date"),new SimpleDateFormat("dd-mm-yyyy").parse(value)));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "dateLT":
                    try {
                        predicates.add(criteriaBuilder.lessThan(personRoot.get("created_date"), new SimpleDateFormat("dd-mm-yyyy").parse(value)));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
            }
        });

        query.select(personRoot).where(predicates.toArray(new Predicate[predicates.size()]));

        //In case that the parameter order has any of these 2 values they will get sorted out by the method chosen
        if (order != null) {
            if (order.contains("user")) {
                query.orderBy(criteriaBuilder.asc(personRoot.get("username")));
            } else if (order.contains("name")) {
                query.orderBy(criteriaBuilder.asc(personRoot.get("name")));
            };
        }

        //Then we return the query with all the filters and ordering done
        List<Person> personList = entityManager.createQuery(query).getResultList().stream().map(Person::new).toList();

        //We declare a PagedListHolder of type Person
        PagedListHolder<Person> page = new PagedListHolder<Person>(personList);
        //Here we set the parameters we want for the paging process
        page.setPageSize(2);
        page.setPage(1);

        return page.getPageList();
    }
}