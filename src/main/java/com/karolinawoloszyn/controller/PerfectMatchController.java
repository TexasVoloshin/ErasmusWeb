package com.karolinawoloszyn.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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
import com.karolinawoloszyn.model.MentorInfo;
import com.karolinawoloszyn.model.PerfectMatch;
import com.karolinawoloszyn.model.User;
import com.karolinawoloszyn.repository.PerfectMatchRepository;
import com.karolinawoloszyn.service.ErasmusInfoService;
import com.karolinawoloszyn.service.MatchingService;
import com.karolinawoloszyn.service.MentorInfoService;
import com.karolinawoloszyn.service.UserService;

@Controller
public class PerfectMatchController {
	
	@Autowired
	 private MatchingService matchingService;
	@Autowired
	 private UserService userService;
	 
	 @Autowired
	 private MentorInfoService mentorInfoService;
	 @Autowired
	 private ErasmusInfoService erasmusInfoService;
	 
	 @Autowired
	 private PerfectMatchRepository perfectMatchRepository;
	 
	 @Autowired
	 private UserController userController;

   Logger log = LoggerFactory.getLogger(this.getClass());
    


 
   
   
//
//  @RequestMapping(value= {"/home/admin/matching"}, method=RequestMethod.GET)
//   public ModelAndView matchErasmusToMentor() {
//    ModelAndView model = new ModelAndView();
//    PerfectMatch perfectMatch = new PerfectMatch();
//    model.addObject("perfectMatch", perfectMatch);
//    model.setViewName("home/perfectMatch");
//   
//    return model;
//  }
 /* @RequestMapping(value= {"/home/admin/matchingDone"}, method=RequestMethod.GET)
  public ModelAndView matchErasmusToMentorDone() {
   ModelAndView model = new ModelAndView();
   PerfectMatch perfectMatch = new PerfectMatch();
   model.addObject("perfectMatch", perfectMatch);
   model.setViewName("matchingDone");
  
   return model;
  }*/


//  @RequestMapping(value = {"/home/admin/matching"}, method = RequestMethod.POST)
//	public ModelAndView matchSubmit(@ModelAttribute PerfectMatch perfectMatch) {
//		ModelAndView model = new ModelAndView();
//
//		SecurityContext securityContext = SecurityContextHolder.getContext();
//		String email = securityContext.getAuthentication().getName();
//		String country=
//		
//		MentorId mentorId = matchingService.findUserByEmail(email);
//		perfectMatch.setMentorId(mentorId);
//		perfectMatch = matchingService.saveMach(perfectMatch);
//  }	

 /* @RequestMapping(value= {"/home/admin/matching"}, method=RequestMethod.GET)
   public ModelAndView matchErasmusToMentor() {
    ModelAndView model = new ModelAndView();
    PerfectMatch perfectMatch = new PerfectMatch();
    model.addObject("perfectMatch", perfectMatch);
    model.setViewName("home/perfectMatch");
   
    return model;
  }*/

   
  @RequestMapping(value = {"/home/admin/assign_pairs"}, method = RequestMethod.POST)
	public ModelAndView matchSubmit() {
	  
	  //step1 - by country
	  
	  List<ErasmusInfo> unpairedErasmusStudents = userService.findUnpairedErasmusStudents();
	  
	  Map<String, ErasmusInfo> erasmusInfoMap = unpairedErasmusStudents.stream().
			  collect(Collectors.toMap(ErasmusInfo::getErasmusCountry, Function.identity()));
	  
	  List<MentorInfo> unpairedMentors = userService.findUnpairedMentors();
	  
	  Map<String, MentorInfo> mentorInfoMap = unpairedMentors.stream().
			  collect(Collectors.toMap(MentorInfo::getMentorCountryOfErasmus, Function.identity()));
	  
	  Set<ErasmusInfo> erasmusInfoWithPair = erasmusInfoMap.entrySet().stream().
			  filter(e -> mentorInfoMap.containsKey(e.getKey())).
			  map(e -> e.getValue()).collect(Collectors.toSet());
	  
	  erasmusInfoWithPair.stream().forEach(e -> savePairByCountry(e, mentorInfoMap));
	  
	  //step 2 - by faculty
	  
	  unpairedErasmusStudents = userService.findUnpairedErasmusStudents();
	  unpairedMentors = userService.findUnpairedMentors();
	  
	  Map<String, ErasmusInfo> erasmusInfoMapFaculty = unpairedErasmusStudents.stream().
			  collect(Collectors.toMap(ErasmusInfo::getErasmusFacultyAGH, Function.identity()));
	  Map<String, MentorInfo> mentorInfoMapFaculty = unpairedMentors.stream().
			  collect(Collectors.toMap(MentorInfo::getMentorFacultyAGH, Function.identity()));
	  
	  erasmusInfoWithPair = erasmusInfoMapFaculty.entrySet().stream().
			  filter(e -> mentorInfoMapFaculty.containsKey(e.getKey())).
			  map(e -> e.getValue()).collect(Collectors.toSet());
	  
	  erasmusInfoWithPair.stream().forEach(e -> savePairByFaculty(e, mentorInfoMapFaculty));
	  
	  
	  
	  //step 3 - by studies
	  
	  
	  return userController.matchingResult();
  
	   /*ModelAndView model = new ModelAndView();
		SecurityContext securityContext = SecurityContextHolder.getContext();
		String email = securityContext.getAuthentication().getName();
		String country=
		
		MentorId mentorId = matchingService.findUserByEmail(email);
	    perfectMatch.setMentorId(mentorId);
		perfectMatch = matchingService.saveMach(perfectMatch);

		model.addObject("perfectMatch", perfectMatch);
		model.setViewName("home/matching");
		return model;*/
	}
  
  private void savePairByCountry(ErasmusInfo erasmusInfo, Map<String, MentorInfo> mentorInfoMap) {
	  String key = erasmusInfo.getErasmusCountry();
	  MentorInfo mentorInfo = mentorInfoMap.get(key);
	  
	  PerfectMatch perfectMatch = new PerfectMatch();
	  perfectMatch.setErasmus(erasmusInfo);
	  perfectMatch.setMentor(mentorInfo);
	  
	  perfectMatch = perfectMatchRepository.save(perfectMatch);
	  
  }
  
  private void savePairByFaculty(ErasmusInfo erasmusInfo, Map<String, MentorInfo> mentorInfoMap) {
	  String key = erasmusInfo.getErasmusFacultyAGH();
	  MentorInfo mentorInfo = mentorInfoMap.get(key);
	  
	  PerfectMatch perfectMatch = new PerfectMatch();
	  perfectMatch.setErasmus(erasmusInfo);
	  perfectMatch.setMentor(mentorInfo);
	  
	  perfectMatchRepository.save(perfectMatch);
  }
  
  
/* @RequestMapping(value = {"/home/admin/assign_pairs"}, method = RequestMethod.POST)
	public ModelAndView showPair() {
	  
	  //how single pair
	  
	  List<User> allUsers = userService.findAllOrderedByNameDescending()();
	  
	  Map<String, User> mapPair = allUsers.stream().
			  collect(Collectors.toMap(User::getUserId, Function.identity()));
	  
	  List<PerfectMatch> perfectMatchs = matchingService.findAll();
	  
	  Map<String, MentorInfo> mentorInfoMap = perfectMatchs.stream().
			  collect(Collectors.toMap(PerfectMatch::getId, Function.identity()));
	  
	  Set<ErasmusInfo> erasmusInfoWithPair = erasmusInfoMap.entrySet().stream().
			  filter(e -> mentorInfoMap.containsKey(e.getKey())).
			  map(e -> e.getValue()).collect(Collectors.toSet());
	  
	  erasmusInfoWithPair.stream().forEach(e -> savePairByCountry(e, mentorInfoMap));
 */
} 