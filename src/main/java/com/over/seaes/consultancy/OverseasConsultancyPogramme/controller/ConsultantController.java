package com.over.seaes.consultancy.OverseasConsultancyPogramme.controller;

import com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.*;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.AppointmentService;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.LoginService;
import com.over.seaes.consultancy.OverseasConsultancyPogramme.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/consultant")
public class ConsultantController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/index")
    public String index(Model model,Principal principal){

        Login login = this.loginService.findByEmailId(principal.getName());

        List<Appointment> appointments = this.appointmentService.findByConsultantId(login.getConsultant().getConsultantId());
        model.addAttribute("appointments",appointments);

        return "consultant/index";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordForm(){
        return "consultant/forgot-pass";
    }

    @PostMapping("/password")
    @ResponseBody
    public String updatePassword(@RequestParam("password")String password,@RequestParam("opassword")String oldPassword, Principal principal){

        try
        {
            Login login = this.loginService.findByEmailId(principal.getName());


            if(passwordEncoder.matches(oldPassword,login.getPassword())){
                login.setPassword(this.passwordEncoder.encode(password));
                this.loginService.save(login);
            }
            else {
                return "Your Old password is wrong";
            }


        }
        catch (Exception e){
            e.getMessage();
            return "error";
        }

        return "success";
    }

    @PostMapping("/book-appointment-accept")
    @ResponseBody
    public String acceptAppointement(@RequestParam("appointmentId")Long appointmentId){

        try{
            Appointment appointment = this.appointmentService.findById(appointmentId);
            appointment.setAction(String.valueOf(Common.ACCEPT));
            this.appointmentService.save(appointment);

        }
        catch (Exception e){
            e.getMessage();
        }

        return "success";
    }

    @GetMapping("/studentDetail/{id}")
    public String studentDetail(@PathVariable("id")Long id,Model model){
        Student student = this.studentService.findById(id);
        model.addAttribute("student",student);
        return "consultant/student_info";
    }

    @GetMapping("/all-appointment")
    public String appointementDetail(Model model,Principal principal){
        List<Appointment> appointments = this.appointmentService.findByConsultantIdWithAccept(this.loginService.findByEmailId(principal.getName()).getConsultant().getConsultantId());
        model.addAttribute("appointments",appointments);
        return "consultant/all-booking";
    }

    @PostMapping("/generate-schedule")
    @ResponseBody
    public String scheduleData(@RequestParam("startDateTime")String  startDateAndTime
                                ,@RequestParam("endTime")String endTime,
                               @RequestParam("appointmentId")Long appointmentId
                               ){

        try{

            Appointment appointment = this.appointmentService.findById(appointmentId);
            appointment.setStartTimeDate(startDateAndTime);
            appointment.setEndTime(endTime);
            this.appointmentService.save(appointment);

        }
        catch (Exception e){
            e.getMessage();
        }
        return "success";
    }

}
