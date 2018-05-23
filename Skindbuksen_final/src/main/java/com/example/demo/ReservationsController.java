package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ReservationsController {

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping(value="/reservationInfo")
    public String reservationInfo(Model model) {
        List<Reservation> all = reservationRepository.findAll();
        GregorianCalendar greg = new GregorianCalendar();
        Collections.sort(all, Collections.reverseOrder());
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

    @RequestMapping("/redigerReservation/{id}")
    public String redigerReservation(@PathVariable Integer id, Model model)   {
        model.addAttribute("reservation", reservationRepository.findById(id));
        model.addAttribute("reservationer", reservationRepository.findAll());
        System.out.println(reservationRepository.findById(id));
        return "redigerReservation";
    }

    @PostMapping("/redigerReservation")
    public String redigerReservation(@ModelAttribute Reservation reservation, Model model)  {
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
        reservationRepository.deleteById(reservation.getReservationID());
        model.addAttribute("reservationer", reservationRepository.findAll());
        return "redirect:reservationInfo";
    }
}
