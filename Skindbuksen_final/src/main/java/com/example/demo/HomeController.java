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

    @RequestMapping(value="/")
    public String home(){
        return "home";
    }

    @RequestMapping(value="/user")
    public String user(){
        return "user";
    }

    @RequestMapping(value="/admin")
    public String admin(Model model){
        List<Bruger> all = brugerRepository.findAll();
        model.addAttribute("brugere", all);
        return "admin";
    }

    @GetMapping("/OpretBruger")
    public String OpretBruger(Model model) {
        model.addAttribute("bruger", new Bruger());
        return "OpretBruger";
    }
    @PostMapping("/OpretBruger")
    public String OpretBruger(@ModelAttribute Bruger bruger, Model model) {
        brugerRepository.insert(bruger);
        model.addAttribute("brugere", brugerRepository.findAll());
        return "redirect:admin";
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
