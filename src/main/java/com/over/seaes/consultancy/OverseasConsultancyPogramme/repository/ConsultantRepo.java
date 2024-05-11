package com.over.seaes.consultancy.OverseasConsultancyPogramme.repository;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsultantRepo extends JpaRepository<Consultant,Long> {

}
