package com.over.seaes.consultancy.OverseasConsultancyPogramme.modal;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_appointment")

public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private LocalDate created_on;

    private LocalDate modified_on;

    private String status;

    private String startTimeDate;

    private String endTime;

    private String action;
    @ManyToOne
    private Consultant consultant;

    public Consultant getConsultant() {
        return consultant;
    }

    @ManyToOne
    private Student student;
}
