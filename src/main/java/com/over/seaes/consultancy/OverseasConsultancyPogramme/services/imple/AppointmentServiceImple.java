package com.over.seaes.consultancy.OverseasConsultancyPogramme.services.imple;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Appointment;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Student;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.repository.AppointmentRepo;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentServiceImple implements AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Override
    public Appointment save(Appointment appointment) {
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public Appointment findById(long id) {
        return this.appointmentRepo.findById(id).get();
    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepo.findAll();
    }

    @Override
    public void delete(Appointment appointment) {
    this.appointmentRepo.delete(appointment);
    }

    @Override
    public List<Appointment> findByConsultantId(Long consultantId) {
        return this.appointmentRepo.findByConsultantId(consultantId);
    }

    @Override
    public List<Appointment> findByConsultantIdWithAccept(Long consultantId) {
        return this.appointmentRepo.findByConsultantIdWithAccept(consultantId);
    }

    @Override
    public List<Appointment> findByStudentId(Long studentId) {
        return this.appointmentRepo.findByStudentId(studentId);
    }
}
