package com.example.block7crudvalidation.teacher.infrastructure.repository;

import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
