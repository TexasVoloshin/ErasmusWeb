package com.karolinawoloszyn.controller;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karolinawoloszyn.model.ErasmusInfo;
import com.karolinawoloszyn.model.User;
import com.karolinawoloszyn.service.UserService;
 
 
@Controller
public class ErasmusInfoController {
	 @Autowired
	 private UserService userService;
 
    Logger log = LoggerFactory.getLogger(this.getClass());
     
   /* @RequestMapping(value="application_form", method=RequestMethod.GET)
    public String customerForm(Model model) {
        model.addAttribute("erasmusInfo", new ErasmusInfo());
        
        return "form/application_form";
    }
    */
    
    
   /* @RequestMapping(value= {"/application_form"}, method=RequestMethod.GET)
    public ModelAndView formPage() {
     ModelAndView model = new ModelAndView();
     model.setViewName("form/form_Erasmus");
     return model;
   }
    */
    
   @RequestMapping(value= {"/application_form"}, method=RequestMethod.GET)
    public ModelAndView signupMentor() {
     ModelAndView model = new ModelAndView();
     ErasmusInfo erasmusInfo = new ErasmusInfo();
     model.addObject("erasmusInfo", erasmusInfo);
    model.setViewName("form/form_Erasmus");
    
     return model;
    }


    @RequestMapping(value= {"/erasmusApplicationResult"}, method=RequestMethod.GET)
    public ModelAndView resultErasmus() {
     ModelAndView model = new ModelAndView();
     model.setViewName("form/erasmusApplicationResult");
     return model;
    }
    
  @RequestMapping(value="/application_form}", method=RequestMethod.POST)
    public String erasmusSubmit(@ModelAttribute ErasmusInfo erasmusInfo, Model model) {
         
        model.addAttribute("erasmusInfo", erasmusInfo);
        String info = String.format("Erasmus Submission: , ErasmusName ='%s', ErasmusSurname = '%s'", 
        		 erasmusInfo.getErasmusName(), erasmusInfo.getErasmusSurname());
        log.info(info);
         
        return "form/erasmusApplicationResult";
    }
    
   /* @RequestMapping(value= {"/application_form"}, method=RequestMethod.POST)
    public ModelAndView ErasmusApplication(@Valid ErasmusInfo erasmusInfo, BindingResult bindingResult) {
     ModelAndView model = new ModelAndView();
      
      userService.saveMentor(erasmusInfo);
      model.addObject("msg", "Ypur application has been sent  successfully! You can await contact from your mentor");
      model.addObject("erasmusInfo", new ErasmusInfo());
      model.setViewName("erasmusApplicationResult");
     }
     
     return model;
    }*/
 
}