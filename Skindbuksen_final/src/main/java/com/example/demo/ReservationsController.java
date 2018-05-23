package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
//Controller til reservationer
@Controller
public class ReservationsController {
    //her initializer vores repository
    @Autowired
    ReservationRepository reservationRepository;

    //Metode til at vise en lise over alle reservationer
    @RequestMapping(value="/reservationInfo")
    public String reservationInfo(Model model) {
        //Sætter alle reservationer fra databasen ind i en Liste
        List<Reservation> all = reservationRepository.findAll();
        //Sortere alle reservationer efter dato
        Collections.sort(all, Collections.reverseOrder());
        model.addAttribute("reservationer", all);
        return "reservationInfo";
    }
    //Opretter en ny reservation
    @GetMapping("/OpretReservation")
    public String OpretReservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "OpretReservation";
    }
    @PostMapping("/OpretReservation")
    public String OpretReservation(@ModelAttribute Reservation reservation, Model model) {
        //Sætter en ny reservation ind i databasen
        reservationRepository.insert(reservation);
        model.addAttribute("reservationer", reservationRepository.findAll());
        return "redirect:reservationInfo";
    }
    //Redigere en reservation via dets id
    @RequestMapping("/redigerReservation/{id}")
    public String redigerReservation(@PathVariable Integer id, Model model)   {
        //finder en reservation via id fra databasen
        model.addAttribute("reservation", reservationRepository.findById(id));
        model.addAttribute("reservationer", reservationRepository.findAll());
        return "redigerReservation";
    }

    @PostMapping("/redigerReservation")
    public String redigerReservation(@ModelAttribute Reservation reservation, Model model)  {
        //rediger en reservation via id i databasen
        int update = reservationRepository.update(reservation);
        model.addAttribute("reservation", reservationRepository.findAll());
        return "redirect:/reservationInfo";
    }


    @GetMapping(value="/sletReservation/{id}")
    public String sletReservation(@PathVariable("id") int id, Model model) {
        model.addAttribute("reservation", reservationRepository.findById(id));
        model.addAttribute("reservationer", reservationRepository.findAll());
        return "sletReservation";
    }

    @PostMapping(value="/sletReservation")
    public String sletReservation(@ModelAttribute Reservation reservation, Model model) {
        //Sletter en en reservation via id
        reservationRepository.deleteById(reservation.getReservationID());
        model.addAttribute("reservationer", reservationRepository.findAll());
        return "redirect:reservationInfo";
    }
}
