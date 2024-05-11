package com.over.seaes.consultancy.OverseasConsultancyPogramme.modal;

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
@Table(name = "tbl_consultant")

public class Consultant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consultantId;

    private String name;

    private boolean isVerified;

    private String profileImg;
    @Column(length = 2000)
    private String specification;

    private String action;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "login_id")
    private Login login;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consultant")
    private List<Appointment> appointments;


}
