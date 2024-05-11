package com.over.seaes.consultancy.OverseasConsultancyPogramme.services;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Appointment;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Student;

import java.util.List;

public interface AppointmentService {

    Appointment save(Appointment appointment);
    Appointment findById(long id);

    List<Appointment> findAll();

    void delete(Appointment appointment);

    List<Appointment> findByConsultantId(Long consultantId);

    List<Appointment> findByConsultantIdWithAccept(Long consultantId);

    List<Appointment> findByStudentId(Long studentId);
}
