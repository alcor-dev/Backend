package com.example.block7crudvalidation.studentsubject.application;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.studentsubject.domain.StudentSubject;
import com.example.block7crudvalidation.studentsubject.infrastructure.repository.StudentSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService{

    @Autowired
    StudentSubjectRepository studentSubjectRepository;

    @Override
    public String createSubjects(StudentSubject studentSubject) {
        studentSubjectRepository.save(studentSubject);
        return null;
    }

    @Override
    public StudentSubject readSubjects(String id) throws EntityNotFoundException {
        return studentSubjectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public String modifySubjects(StudentSubject studentSubject)  {
        studentSubjectRepository.save(studentSubject);
        return null;
    }

    @Override
    public void deleteSubjects(String id)  {
        studentSubjectRepository.deleteById(id);
    }

    @Override
    public List<StudentSubject> readEverySubject() {
        List<StudentSubject> subjectRecover = new ArrayList<>();
        studentSubjectRepository.findAll().forEach(subject -> subjectRecover.add(subject));
        return subjectRecover;
    }
}
