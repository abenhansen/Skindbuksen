package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BestillingController {
    @Autowired
    BestillingRepository bestillingRepository;
    @Autowired
    MaaltidRepository maaltidRepository;

    @RequestMapping(value="/BestillingInfo")
    public String BestillingInfo(Model model){
        List<Bestilling> all = bestillingRepository.findAll();
        model.addAttribute("bestillinger", all);
        List<Maaltid> alle = maaltidRepository.findAll();
        model.addAttribute("maaltider", alle);
        return "BestillingInfo";
    }

    @GetMapping("/OpretBestilling")
    public String OpretBestilling(Model model) {
        model.addAttribute("bestilling", new Bestilling());
        return "OpretBestilling";
    }

    @PostMapping("/OpretBestilling")
    public String OpretBestilling(@ModelAttribute Bestilling bestilling, Model model) {
        bestillingRepository.insert(bestilling);
        model.addAttribute("bestilling", bestillingRepository.findAll());
        return "redirect:BestillingInfo";
    }

    @GetMapping(value="/sletBestilling/{id}")
    public String sletBestilling(@PathVariable("id") int id, Model model) {
        model.addAttribute("bestilling", bestillingRepository.findById(id));
        model.addAttribute("bestillinger", bestillingRepository.findAll());
        return "sletBestilling";
    }

    @PostMapping(value="/sletBestilling")
    public String sletBestilling(@ModelAttribute Bestilling bestilling, Model model) {
        bestillingRepository.deleteById(bestilling.getId());
        model.addAttribute("bestillinger", bestillingRepository.findAll());
        return "redirect:BestillingInfo";
    }

    @RequestMapping("/redigerBestilling/{id}")
    public String redigerBestilling(@PathVariable Integer id, Model model)   {
        model.addAttribute("bestilling", bestillingRepository.findById(id));
        model.addAttribute("bestillinger", bestillingRepository.findAll());
        System.out.println(bestillingRepository.findById(id));
        return "redigerBestilling";
    }

    @PostMapping("/redigerBestilling")
    public String redigerBestilling(@ModelAttribute Bestilling bestilling, Model model)  {
        int update = bestillingRepository.update(bestilling);
        model.addAttribute("bestilling", bestillingRepository.findAll());
        return "redirect:/BestillingInfo";
    }
}
