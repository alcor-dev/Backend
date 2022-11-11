package com.example.block7crudvalidation.studentsubject.application;

import com.example.block7crudvalidation.studentsubject.domain.StudentSubject;

import java.util.List;

public interface StudentSubjectService {

    String createSubjects(StudentSubject studentSubject);
    StudentSubject readSubjects(int id) throws Exception;
    String modifySubjects(StudentSubject studentSubject) ;
    void deleteSubjects(int id);
    List<StudentSubject> readEverySubject();
}
