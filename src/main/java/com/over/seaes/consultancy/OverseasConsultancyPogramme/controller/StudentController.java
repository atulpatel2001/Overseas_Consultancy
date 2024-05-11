package com.over.seaes.consultancy.OverseasConsultancyPogramme.controller;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.*;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.AppointmentService;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.ConsultantService;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ConsultantService consultantService;
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/index")
    public String index(Model model) {




        return "student/index";
    }

    @GetMapping("/take-appointment")
    public String bookAppoiment(Model model){
        List<Consultant> consultants = this.consultantService.findAll();

        model.addAttribute("consultants", consultants);
        return "student/book-appoiment";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordForm() {
        return "student/forgot-pass";
    }

    @PostMapping("/password")
    @ResponseBody
    public String updatePassword(@RequestParam("password") String password, @RequestParam("opassword") String oldPassword, Principal principal) {

        try {
            Login login = this.loginService.findByEmailId(principal.getName());


            if (passwordEncoder.matches(oldPassword, login.getPassword())) {
                login.setPassword(this.passwordEncoder.encode(password));
                this.loginService.save(login);
            } else {
                return "Your Old password is wrong";
            }


        } catch (Exception e) {
            e.getMessage();
            return "error";
        }

        return "success";
    }


    @PostMapping("/book-appointment")
    @ResponseBody
    public String bookAppoiment(@RequestParam("consultantId")Long consultantId,Principal principal){
        try
        {
            Consultant consultant = this.consultantService.findById(consultantId);
            Student student = this.loginService.findByEmailId(principal.getName()).getStudent();

            Appointment appointment = Appointment.builder().
                    created_on(LocalDate.now())
                    .action(String.valueOf(Common.PENDING))
                    .status(String.valueOf(Common.PENDING))
                    .student(student)
                    .consultant(consultant).build();
            this.appointmentService.save(appointment);


        }
        catch (Exception e){
            e.getMessage();
        }
       return "success";
    }

    @GetMapping("/all-appointment")
    public String appointementDetail(Model model,Principal principal){
        List<Appointment> appointments = this.appointmentService.findByStudentId(this.loginService.findByEmailId(principal.getName()).getStudent().getStudentId());
        model.addAttribute("appointments",appointments);
        List<Consultant> consultants = this.consultantService.findAll();
        model.addAttribute("consultants", consultants);
        return "student/all-booking";
    }

    @PostMapping("/change-consultant")
    @ResponseBody
    public String changeConsultant(@RequestParam("consultantId") Long consultantId,@RequestParam("appointmentId")Long appointmentId){
        try{
            Appointment appointment = this.appointmentService.findById(appointmentId);
            Consultant consultant = this.consultantService.findById(consultantId);
            appointment.setModified_on(LocalDate.now());
            appointment.setConsultant(consultant);

            this.appointmentService.save(appointment);

        }
        catch (Exception e){
            e.getMessage();
        }
        return "success";
    }
    @GetMapping("/consultant-detail/{id}")
    public String studentDetail(@PathVariable("id")Long id,Model model){
        Consultant consultant = this.consultantService.findById(id);
        model.addAttribute("consultant",consultant);
        return "student/consultant_info";
    }
}
