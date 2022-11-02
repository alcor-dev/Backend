package com.example.block7crudvalidation.teacher.infrastructure.repository;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, String> {
}
