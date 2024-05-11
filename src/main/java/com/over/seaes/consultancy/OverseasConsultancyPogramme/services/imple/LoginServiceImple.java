package com.over.seaes.consultancy.OverseasConsultancyPogramme.services.imple;


import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Login;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.repository.LoginRepo;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImple implements LoginService {
@Autowired
    private LoginRepo loginRepo;

    @Override
    public Login findByEmailId(String emailId) {
        return this.loginRepo.findByEmailId(emailId);
    }

    @Override
    public Login save(Login login) {
        return this.loginRepo.save(login);
    }

    @Override
    public Login findById(Long id) {
        return this.loginRepo.findById(id).get();
    }
}
