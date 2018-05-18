package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReservationsController {

    @Autowired
    ReservationRepository reservationRepository;

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
}
