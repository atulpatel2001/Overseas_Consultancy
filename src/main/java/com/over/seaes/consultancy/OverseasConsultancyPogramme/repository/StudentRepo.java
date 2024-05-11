package com.over.seaes.consultancy.OverseasConsultancyPogramme.repository;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
