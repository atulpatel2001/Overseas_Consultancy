package com.over.seaes.consultancy.OverseasConsultancyPogramme.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    private String name;

    private boolean isVerified;

    private String profileImg;

    @Column(length = 2000)
    private String specification;

    private String action;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "login_id")
    private Login login;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
    @JsonBackReference
    private List<Appointment> appointments;


}
