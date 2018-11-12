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

import com.karolinawoloszyn.model.MentorInfo;
import com.karolinawoloszyn.model.User;
import com.karolinawoloszyn.service.MentorInfoService;
import com.karolinawoloszyn.service.UserService;
 
 
@Controller
public class MentorInfoController {
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private MentorInfoService mentorInfoService;
 
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
    
   @RequestMapping(value= {"/assign_erasmus"}, method=RequestMethod.GET)
    public ModelAndView assignErasmus() {
     ModelAndView model = new ModelAndView();
     MentorInfo mentorInfo = new MentorInfo();
     model.addObject("mentorInfo", mentorInfo);
    model.setViewName("form/form_Mentor");
    
     return model;
    }


    @RequestMapping(value= {"/mentorApplicationResult"}, method=RequestMethod.GET)
    public ModelAndView resultMentor() {
     ModelAndView model = new ModelAndView();
     model.setViewName("form/mentorApplicationResult");
     return model;
    }
    
	@RequestMapping(value = "/assign_erasmus", method = RequestMethod.POST)
	public ModelAndView mentorSubmit(@ModelAttribute MentorInfo mentorInfo) {
		ModelAndView model = new ModelAndView();

		SecurityContext securityContext = SecurityContextHolder.getContext();
		String email = securityContext.getAuthentication().getName();
		
		User user = userService.findUserByEmail(email);
		MentorInfo.setUser(user);
		mentorInfo = mentorInfoService.saveMentorInfo(mentorInfo);

		model.addObject("mentorInfo", mentorInfo);
		model.setViewName("form/mentorApplicationResult");
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