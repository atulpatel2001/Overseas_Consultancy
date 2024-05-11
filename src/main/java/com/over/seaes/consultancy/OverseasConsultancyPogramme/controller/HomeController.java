package com.over.seaes.consultancy.OverseasConsultancyPogramme.controller;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.helper.FileHelper;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Common;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Consultant;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Login;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Student;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.ConsultantService;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.LoginService;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private LoginService loginService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ConsultantService consultantService;
    @GetMapping("/")
    public String indexPage(){

        return "index";
    }

    @GetMapping("/signin")
    public String sigin(Model model) {
        return "login";
    }

    @PostMapping("/select-signup")
    public String selectPage(@RequestParam("role") String role){
        if(role.equals("Consultant")){
            return "consultant";
        } else if (role.equals("Student")) {
            return "student";
        }
        else {
            return "redirect:/";
        }


    }

    @PostMapping("/consultant-data")
    @ResponseBody
    public String consultantData(@RequestParam("name")String name,
                                 @RequestParam("emailId")String emailId,
                                 @RequestParam("password")String password,
                                 @RequestParam("specification")String specification,
                                 @RequestParam("profileImg")MultipartFile profileImg
                                 ){

        try {

            Login loginData = this.loginService.findByEmailId(emailId);
            if (loginData == null){
                boolean b = FileHelper.uploadFile("static/image/consltunt-img", profileImg);
            if (b) {
                Login build = Login.builder().emailId(emailId).password(this.passwordEncoder.encode(password)).role(String.valueOf(Common.ROLE_CONSULTANT)).build();
                Login login = this.loginService.save(build);
                Consultant consultant = Consultant.builder().name(name).isVerified(true).profileImg(profileImg.getOriginalFilename()).specification(specification).login(login).build();
                this.consultantService.save(consultant);
            }
        }
            else {
                return "this email id is already register";
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }

    @PostMapping("/student-data")
    @ResponseBody
    public String studentData(@RequestParam("name")String name,
                                 @RequestParam("emailId")String emailId,
                                 @RequestParam("password")String password,
                                 @RequestParam("specification")String specification,
                                 @RequestParam("profileImg")MultipartFile profileImg
    ){
        try{
            Login loginData = this.loginService.findByEmailId(emailId);
            if (loginData == null) {
                boolean b = FileHelper.uploadFile("static/image/student-img", profileImg);
                if (b) {
                    Login build = Login.builder().emailId(emailId).password(this.passwordEncoder.encode(password)).role(String.valueOf(Common.ROLE_STUDENT)).build();
                    Login login = this.loginService.save(build);
                    Student student = Student.builder().name(name).isVerified(true).profileImg(profileImg.getOriginalFilename()).specification(specification).login(login).build();
                    this.studentService.save(student);
                }
            }

            else {
                return "this email id is already register";
            }



        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }
}
