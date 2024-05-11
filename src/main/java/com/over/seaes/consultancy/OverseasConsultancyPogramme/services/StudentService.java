package com.over.seaes.consultancy.OverseasConsultancyPogramme.services;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);
    Student findById(Long id);

    List<Student> findAll();

    void delete(Student student);
}
