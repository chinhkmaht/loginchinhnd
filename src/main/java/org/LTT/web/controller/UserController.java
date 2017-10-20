package org.LTT.web.controller;

import java.util.List;
import java.util.Locale;

import org.LTT.persistence.dao.CompanyCardRepository;
import org.LTT.persistence.dao.UniversityRepository;
import org.LTT.persistence.dao.UserRepository;
import org.LTT.persistence.model.User;
import org.LTT.security.ActiveUserStore;
import org.LTT.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    ActiveUserStore activeUserStore;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyCardRepository companycardrepository;
    
    @Autowired
    private UniversityRepository universityRepository;
    
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/loggedUsers", method = RequestMethod.GET)
    public String getLoggedUsers(final Locale locale, final Model model) {
    	System.out.println(" loggedUsers ");
        model.addAttribute("users", activeUserStore.getUsers());
        return "users";
    }
    @RequestMapping(value = "/searchuser",method = RequestMethod.POST)
    @ResponseBody
    public String search(Model model, @RequestParam String userLastName, @RequestParam String userFirtName, @RequestParam long userUniver){
        System.out.println(" searchuser  00000    ");
        model.addAttribute("result",userRepository.findByLastNameOrFirstNameOrUniversityId(userLastName,userFirtName,51));

        model.addAttribute("univer",universityRepository.findByStatus(true));
        return "searchuser";
    }

    @RequestMapping(value = "/loggedUsersFromSessionRegistry", method = RequestMethod.GET)
    public String getLoggedUsersFromSessionRegistry(final Locale locale, final Model model) {
    	System.out.println(" loggedUsersFromSessionRegistry ");
        model.addAttribute("users", userService.getUsersFromSessionRegistry());
        return "users";
    }
    @RequestMapping(value = "/userlist",method = RequestMethod.GET)
    public String listalluser(Model model){
        model.addAttribute("userlist",userRepository.findByLastNameOrFirstNameOrUniversityId("","",32));
       // model.addAttribute("userlist",userRepository.findByEnabled(true));
        model.addAttribute("univer",universityRepository.findByStatus(true));
        return "users";
    }
    
    @RequestMapping(value="/deletelogicuser",method = RequestMethod.GET)
    public String delete(Model model,@RequestParam long id) {
    	User user = userRepository.findOne(id);
    	if(user !=null) {
    		user.setEnabled(false);
    		userRepository.save(user);
    		
    	}else {
    		
    	}
    	return "users";
    }
    
    @RequestMapping(value="/editlastname",method = RequestMethod.POST)
    public String editablelastname(Model model, @RequestParam long id, @RequestParam String name) {
    	
    	User user = userRepository.findOne(id);
    	if(user !=null) {
    		user.setLastName(name);
    		userRepository.save(user);
    		
    	}else {
    		
    	}
    	return "";
    }
    
    @RequestMapping(value="/editfirtname",method = RequestMethod.POST)
    public String editablefirtname(Model model, @RequestParam long id, @RequestParam String name) {
    	
    	User user = userRepository.findOne(id);
    	if(user !=null) {
    		user.setFirstName(name);;
    		userRepository.save(user);
    		
    	}else {
    		
    	}
    	return "";
    }
}
