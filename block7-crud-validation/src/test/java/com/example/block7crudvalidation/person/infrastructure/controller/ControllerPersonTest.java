package com.example.block7crudvalidation.person.infrastructure.controller;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.person.application.PersonServiceImpl;
import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.person.infrastructure.repository.PersonRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;



@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControllerPersonTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    PersonServiceImpl personService;

    private Person person;

    @BeforeEach
    void personCreated(){
        person = Person.builder()
                .id_person(1)
                .name("David")
                .surname("Martinez")
                .username("sandevistanUser")
                .company_email("d.Martinez@Arasaka.com")
                .personal_email("chromedMan@gmail.com")
                .city("Night City")
                .active(true)
                .created_date(Date.valueOf("2010-10-10"))
                .termination_date(Date.valueOf("2076-10-10"))
                .image_url("http://www.holaquepasa.com")
                .password("gimmeMoreChrome")
                .build();
    }

    @Test
    @Order(1)
    void savePersonTest() {
        when(personRepository.save(any(Person.class))).thenReturn((person));
        assertNotNull(personService.createPerson(new Person()));
    }

    @Test
    @Order(2)
    void readPersonTest() {

    }
}