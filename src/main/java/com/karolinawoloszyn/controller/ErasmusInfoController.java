package com.karolinawoloszyn.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karolinawoloszyn.model.ErasmusInfo;
import com.karolinawoloszyn.model.User;
import com.karolinawoloszyn.service.ErasmusInfoService;
import com.karolinawoloszyn.service.UserService;
 
 
@Controller
public class ErasmusInfoController {
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private ErasmusInfoService erasmusInfoService;
 
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
    
	@RequestMapping(value = "/application_form", method = RequestMethod.POST)
	public ModelAndView erasmusSubmit(@ModelAttribute ErasmusInfo erasmusInfo) {
		ModelAndView model = new ModelAndView();

		SecurityContext securityContext = SecurityContextHolder.getContext();
		String email = securityContext.getAuthentication().getName();
		
		User user = userService.findUserByEmail(email);
		erasmusInfo.setUser(user);
		erasmusInfo = erasmusInfoService.saveErasmusInfo(erasmusInfo);

		model.addObject("erasmusInfo", erasmusInfo);
		model.setViewName("form/erasmusApplicationResult");
		return model;
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