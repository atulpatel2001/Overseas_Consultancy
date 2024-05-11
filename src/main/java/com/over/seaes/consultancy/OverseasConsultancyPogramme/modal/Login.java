package com.over.seaes.consultancy.OverseasConsultancyPogramme.modal;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_login")

public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailId;

    private String password;

    private String role;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "login")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "login")
    private Consultant  Consultant ;
}
