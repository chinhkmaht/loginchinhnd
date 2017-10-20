package org.LTT.web.controller;

import org.LTT.persistence.dao.UniversityRepository;
import org.LTT.persistence.model.University;
import org.hibernate.annotations.common.util.impl.Log_$logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
public class university {
    @Autowired
    private UniversityRepository universityRepository;

    @RequestMapping(value = "/adduniversity",method = RequestMethod.POST)
    @ResponseBody
    public String adduniversity(Model model,@RequestParam String nameUniver) {
        System.out.println(" nameUniver  99999999999  "+nameUniver);
        University uni = new University();
        uni.setNameUniver(nameUniver);
        uni.setStatus(true);
        uni.setCreateDate(new Date());
        uni.setModifileDate(new Date());
        universityRepository.save(uni);
        return "university";
    }
    @RequestMapping(value = "/university",method = RequestMethod.GET)
    public String say(Model model){
           model.addAttribute("universitylistall",universityRepository.findByStatus(true));
        return "university";
    }

    @RequestMapping(value = "/edituniver",method = RequestMethod.GET)
    public String edituniversity(Model model,@RequestParam long Id){
        System.out.println("  edituniver  Id   "+Id);
        model.addAttribute("edituniver",universityRepository.findOne(Id));
        return "edituniver";
    }
    @RequestMapping(value = "/saveuniversity",method = RequestMethod.POST)
    @ResponseBody
    public String saveedituniversity (@RequestParam long id,@RequestParam String nameUniver){

        University university = universityRepository.findOne(id);
        System.out.println("3333333333   ");
        if(university !=null ){
            university.setNameUniver(nameUniver);
            universityRepository.save(university);
            return "ok";
        }else {
            return "";
        }

    }


//    @RequestMapping(value = "/saveuniversity", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<Void> createusertest(@RequestParam long id,@RequestParam String nameUniver) {
//        System.out.println("888888888888");
//
//        University university = universityRepository.findOne(id);
//        System.out.println("3333333333   ");
//        if(university !=null ){
//            university.setNameUniver(nameUniver);
//            universityRepository.save(university);
//        }else {
//            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }

    @RequestMapping(value="deletelogicuniversity",method = RequestMethod.POST)
    public String deletelogic(Model model ,@RequestParam long Id){
        System.out.println("deletelogicuniversity  000000000  ");
        University uni = universityRepository.findOne(Id);
        System.out.println("deletelogicuniversity  uni   "+uni);
        if(uni != null){
            uni.setStatus(false);
            universityRepository.save(uni);
        }else{

            return "";
        }
        System.out.println("uni  00000000 = "+uni);
        return "university";
    }

}
