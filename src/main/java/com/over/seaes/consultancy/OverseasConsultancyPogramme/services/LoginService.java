package com.over.seaes.consultancy.OverseasConsultancyPogramme.services;


import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Login;

public interface LoginService {

    Login findByEmailId(String emailId);

    Login save(Login login);

    Login findById(Long id);


}
