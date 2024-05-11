package com.over.seaes.consultancy.OverseasConsultancyPogramme.services;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Consultant;

import java.util.List;

public interface ConsultantService {

    Consultant save (Consultant consultant);
    Consultant findById(Long id);

    List<Consultant> findAll();

    void delete(Consultant consultant);
}
