package com.over.seaes.consultancy.OverseasConsultancyPogramme.services.imple;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Consultant;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.repository.ConsultantRepo;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsultantServiceImple implements ConsultantService {
    @Autowired
    private ConsultantRepo consultantRepo;
    @Override
    public Consultant save(Consultant consultant) {
        return this.consultantRepo.save(consultant);
    }

    @Override
    public Consultant findById(Long id) {
        return this.consultantRepo.findById(id).get();
    }

    @Override
    public List<Consultant> findAll() {
        return this.consultantRepo.findAll();
    }

    @Override
    public void delete(Consultant consultant) {
        this.consultantRepo.delete(consultant);
    }
}
