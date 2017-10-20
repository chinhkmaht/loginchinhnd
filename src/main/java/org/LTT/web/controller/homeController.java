package org.LTT.web.controller;

import org.LTT.persistence.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class homeController {

    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    UserRepository userRepository;

    @RequestMapping( "/")
    public String say1(Model model) {
        System.out.println(" loggedUsers  ///////////////// ");
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String say(Model model) {
        System.out.println(" loggedUsers ");
        return "index";
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getAllUser( Model model){
        model.addAttribute("user",userRepository.findAll());

        return "users";
    }




}
