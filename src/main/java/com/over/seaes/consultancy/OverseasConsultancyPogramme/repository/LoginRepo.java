package com.over.seaes.consultancy.OverseasConsultancyPogramme.repository;


import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepo extends JpaRepository<Login,Long> {

    @Query("select l from Login l where l.emailId =:emailId")
    Login findByEmailId(@Param("emailId") String emailId);
}
