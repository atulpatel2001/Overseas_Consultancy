package com.over.seaes.consultancy.OverseasConsultancyPogramme.services.imple;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Student;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.repository.StudentRepo;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImple implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student save(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepo.findById(id).get();
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepo.findAll();
    }

    @Override
    public void delete(Student student) {
            this.studentRepo.delete(student);
    }
}
