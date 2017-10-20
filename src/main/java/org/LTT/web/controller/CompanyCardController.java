package org.LTT.web.controller;

import org.LTT.persistence.dao.CompanyCardRepository;
import org.LTT.persistence.dao.UserRepository;
import org.LTT.persistence.model.CompanyCard;
import org.LTT.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;


@Controller
public class CompanyCardController {
    @Autowired
    private CompanyCardRepository companyCardRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/companycard",method = RequestMethod.GET)
    public String say(Model model){
        model.addAttribute("companyCard",companyCardRepository.findByStatus(true));

        model.addAttribute("userall",userRepository.findByCompanyCardsIsNull());

        return "companycard";
    }

    @RequestMapping(value = "/addcompanycard",method = RequestMethod.POST)
    @ResponseBody
    public String adduniversity(Model model,@RequestParam long userid, @RequestParam String name) {
        CompanyCard companyCard = new CompanyCard();
        companyCard.setName(name);
        companyCard.setCreateDate(new Date());
        companyCard.setModifileDate(new Date());
        companyCard.setUsers(Arrays.asList(userRepository.findOne(userid)));
        companyCard.setUserId(userid);
        companyCard.setStatus(true);
        companyCardRepository.save(companyCard);
        System.out.println("  addcompanycard   0 0 0 0 0 0 0");
        return "companycard";
    }

    @RequestMapping(value = "/savecompanycard",method = RequestMethod.POST)
    @ResponseBody
    public String saveedituniversity (@RequestParam long id,@RequestParam String name){

        CompanyCard companyCard = companyCardRepository.findOne(id);
        System.out.println("3333333333   ");
        if(companyCard !=null ){
            companyCard.setName(name);
            companyCardRepository.save(companyCard);
            return "ok";
        }else {
            return "";
        }

    }


}
