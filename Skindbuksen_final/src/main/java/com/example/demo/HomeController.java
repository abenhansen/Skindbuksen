package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
   BrugerRepository brugerRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping(value="/")
    public String home(){
        return "home";
    }

    @RequestMapping(value="/user")
    public String user(){
        return "user";
    }

    @RequestMapping(value="/reservationInfo")
    public String reservationInfo(Model model){
        List<Reservation> all = reservationRepository.findAll();
        model.addAttribute("reservationer", all);
        return "reservationInfo";
    }

    @GetMapping("/OpretReservation")
    public String OpretReservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "OpretReservation";
    }
    @PostMapping("/OpretReservation")
    public String OpretReservation(@ModelAttribute Reservation reservation, Model model) {
        reservationRepository.insert(reservation);
        model.addAttribute("reservationer", reservationRepository.findAll());
        return "redirect:reservationInfo";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }

}
