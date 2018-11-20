package com.karolinawoloszyn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karolinawoloszyn.model.MentorInfo;
import com.karolinawoloszyn.model.PerfectMatch;
import com.karolinawoloszyn.model.User;
import com.karolinawoloszyn.service.ErasmusInfoService;
import com.karolinawoloszyn.service.MatchingService;
import com.karolinawoloszyn.service.MentorInfoService;
import com.karolinawoloszyn.service.UserService;

public class PerfectMatchController {
	
	@Autowired
	 private MatchingService matchingService;
	@Autowired
	 private UserService userService;
	 
	 @Autowired
	 private MentorInfoService mentorInfoService;
	 @Autowired
	 private ErasmusInfoService erasmusInfoService;

   Logger log = LoggerFactory.getLogger(this.getClass());
    


 
   
   
  @RequestMapping(value= {"/home/admin/matching"}, method=RequestMethod.GET)
   public ModelAndView matchErasmusToMentor() {
    ModelAndView model = new ModelAndView();
    PerfectMatch perfectMatch = new PerfectMatch();
    model.addObject("perfectMatch", perfectMatch);
    model.setViewName("home/perfectMatch");
   
    return model;
   }
  @RequestMapping(value= {"/home/admin/matchingDone"}, method=RequestMethod.GET)
  public ModelAndView matchErasmusToMentorDone() {
   ModelAndView model = new ModelAndView();
   PerfectMatch perfectMatch = new PerfectMatch();
   model.addObject("perfectMatch", perfectMatch);
   model.setViewName("matchingDone");
  
   return model;
  }
/*
  @RequestMapping(value = {"/home/admin/matching"}, method = RequestMethod.POST)
	public ModelAndView matchSubmit(@ModelAttribute PerfectMatch perfectMatch) {
		ModelAndView model = new ModelAndView();

		SecurityContext securityContext = SecurityContextHolder.getContext();
		String email = securityContext.getAuthentication().getName();
		String country=
		
		MentorId mentorId = matchingService.findUserByEmail(email);
		perfectMatch.setMentorId(mentorId);
		perfectMatch = matchingService.saveMach(perfectMatch);

		model.addObject("perfectMatch", perfectMatch);
		model.setViewName("home/matching");
		return model;
	}*/
 
}