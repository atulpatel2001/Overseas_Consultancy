package com.over.seaes.consultancy.OverseasConsultancyPogramme.repository;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    @Query("select a from Appointment a where a.consultant.consultantId = :consultantId AND a.action = 'PENDING'")
    List<Appointment> findByConsultantId(@Param("consultantId") Long consultantId);

    @Query("select a from Appointment a where a.consultant.consultantId = :consultantId AND a.action = 'ACCEPT'")
    List<Appointment> findByConsultantIdWithAccept(@Param("consultantId") Long consultantId);


    @Query("select a from Appointment a where a.student.studentId =:studentId AND a.action = 'ACCEPT'")
    List<Appointment> findByStudentId(@Param("studentId")Long studentId);
}
