package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Controller der har alt med bestillinger at gøre
@Controller
public class BestillingController {
    //her initializer vi vores repository
    @Autowired
    BestillingRepository bestillingRepository;


    //Vores bestillingInfo side som viser alle bestillinger som skal laves
    @RequestMapping(value="/BestillingInfo")
    public String BestillingInfo(Model model){
        //Her henter vi alt information fra vores database, og putter dem i en Liste af bestillings objekter
        List<Bestilling> all = bestillingRepository.findAll();
        model.addAttribute("bestillinger", all);
        return "BestillingInfo";
    }

    //Lav en ny bestillng
    @GetMapping("/OpretBestilling")
    public String OpretBestilling(Model model) {
        model.addAttribute("bestilling", new Bestilling());
        return "OpretBestilling";
    }

    //Hvad der sker efter man har trykket send på bestilling html siden
    @PostMapping("/OpretBestilling")
    public String OpretBestilling(@ModelAttribute Bestilling bestilling, Model model) {
        //her kører vi en metode som går ind at tilføjer det i databasen
        bestillingRepository.insert(bestilling);
        model.addAttribute("bestilling", bestillingRepository.findAll());
        return "redirect:BestillingInfo";
    }

    //En metode der går ind og tager id for en bestilling og spørger om den vil slettes
    @GetMapping(value="/sletBestilling/{id}")
    public String sletBestilling(@PathVariable("id") int id, Model model) {
        // Finder den bestillinger på dets id plads
        model.addAttribute("bestilling", bestillingRepository.findById(id));
        model.addAttribute("bestillinger", bestillingRepository.findAll());
        return "sletBestilling";
    }

    //Sletter selve bestillingen
    @PostMapping(value="/sletBestilling")
    public String sletBestilling(@ModelAttribute Bestilling bestilling, Model model) {
        //metode der sletter en bestilling i databasen ved brug af dets id
        bestillingRepository.deleteById(bestilling.getId());
        model.addAttribute("bestillinger", bestillingRepository.findAll());
        return "redirect:BestillingInfo";
    }


    @RequestMapping("/redigerBestilling/{id}")
    public String redigerBestilling(@PathVariable Integer id, Model model)   {
        model.addAttribute("bestilling", bestillingRepository.findById(id));
        model.addAttribute("bestillinger", bestillingRepository.findAll());
        return "redigerBestilling";
    }

    @PostMapping("/redigerBestilling")
    public String redigerBestilling(@ModelAttribute Bestilling bestilling, Model model)  {
        //opdaterer en bestilling i databasen
        int update = bestillingRepository.update(bestilling);
        model.addAttribute("bestilling", bestillingRepository.findAll());
        return "redirect:/BestillingInfo";
    }
}
