package com.example.block7crudvalidation.studentsubject.infrastructure.repository;

import com.example.block7crudvalidation.studentsubject.domain.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
}
