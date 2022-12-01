package com.example.block13mongodb.person.infrastructure.controller;

import com.example.block13mongodb.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongodb")
public class personController {

    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person) {
        mongoTemplate.save(person);
        return "Añadido a MongoDB: " + person.getName();
    }

    @GetMapping("/{id}")
    public Person readPerson(@PathVariable("id") Integer idPerson) {
        return mongoTemplate.findById(idPerson, Person.class);
    }

    @GetMapping("/all")
    public List<Person> readAllPerson() {
        //Here we declare the pagination parameters
        int pageSize = 2;
        int pageNumber= 1;

        //Then we create the query that will serve us for asking info with that pagination
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);
        //Returns the search with the pagination
        return mongoTemplate.find(query, Person.class);
    }

    @PutMapping("/update")
    public String updatePerson(@RequestBody Person person) {

        //We create a Query where we decide which parameter becomes the
        //one to choose from, in this case idMongo (as if it wasn't obvious enough)
        Query query = new Query();
        query.addCriteria(Criteria.where("idMongo").is(person.getIdMongo()));

        //Then we set up a new update object and then set it with the info
        //we want to update from the object we decided with the ID
        Update update = new Update();
        update.set("name", person.getName());
        update.set("age", person.getName());
        update.set("city", person.getCity());
        update.set("username", person.getUsername());

        //Once everything is done, we send the query, update and the class so we
        //can update the person we wantS
        mongoTemplate.findAndModify(query, update, Person.class);

        return "El perfil de id: " + person.getIdMongo() + " ha sido actualizado";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer idPerson) {
        Query query = new Query();
        query.addCriteria(Criteria.where("idMongo").is(idPerson));
        mongoTemplate.findAndRemove(query, Person.class);
        return null;
    }
}
