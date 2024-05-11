package com.over.seaes.consultancy.OverseasConsultancyPogramme.configraion;


import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Login;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomLoginDetailServiceImple implements UserDetailsService {

    @Autowired
    private LoginService loginService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = this.loginService.findByEmailId(username);
        if(login== null) {
            throw new UsernameNotFoundException("could Not Found !!! ");
        }

        CustomLoginDetailService customLoginDetailService = new CustomLoginDetailService(login);
        return customLoginDetailService;
    }


}
