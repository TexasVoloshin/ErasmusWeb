package com.karolinawoloszyn.controller;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.karolinawoloszyn.model.ErasmusInfo;
import com.karolinawoloszyn.model.MentorInfo;
import com.karolinawoloszyn.model.PerfectMatch;
import com.karolinawoloszyn.model.Role;
import com.karolinawoloszyn.model.User;
import com.karolinawoloszyn.repository.RoleRespository;
import com.karolinawoloszyn.service.MatchingService;
import com.karolinawoloszyn.service.UserService;

@Controller
public class UserController {

 @Autowired
 private UserService userService;
 

 
 @RequestMapping(value= {"/login"}, method=RequestMethod.GET)
 public ModelAndView login() {
  ModelAndView model = new ModelAndView();
  
  model.setViewName("user/login");
  return model;
 }
 
 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
 public ModelAndView signup() {
  ModelAndView model = new ModelAndView();
  User user = new User();
  model.addObject("user", user);
  model.setViewName("user/signup");
  
  return model;
 }
 @RequestMapping(value= {"/signupMentor"}, method=RequestMethod.GET)
 public ModelAndView signupMentor() {
  ModelAndView model = new ModelAndView();
  User user = new User();
  model.addObject("user", user);
  model.setViewName("user/signupMentor");
  
  return model;
 }
 
 @RequestMapping(value= {"/signupAdmin"}, method=RequestMethod.GET)
 public ModelAndView signupAdmin() {
  ModelAndView model = new ModelAndView();
  User user = new User();
  model.addObject("user", user);
  model.setViewName("user/signupAdmin");
  
  return model;
 }
 
 @RequestMapping(value= {"/signup_erasmus"}, method=RequestMethod.POST)
 public ModelAndView createErasmus(@Valid User user, BindingResult bindingResult) {
  ModelAndView model = new ModelAndView();
  User userExists = userService.findUserByEmail(user.getEmail());
  
  if(userExists != null) {
   bindingResult.rejectValue("email", "error.user", "This email already exists!");
  }
  if(bindingResult.hasErrors()) {
   model.setViewName("user/signup");
  } else {
   userService.saveErasmus(user);
   model.addObject("msg", "User has been registered successfully!");
   model.addObject("user", new User());
   model.setViewName("user/signup");
  }

  return model;
 }
 
 
 
 @RequestMapping(value= {"/signup_mentor"}, method=RequestMethod.POST)
 public ModelAndView createMentor(@Valid User user, BindingResult bindingResult) {
  ModelAndView model = new ModelAndView();
  User userExists = userService.findUserByEmail(user.getEmail());
  
  if(userExists != null) {
   bindingResult.rejectValue("email", "error.user", "This email already exists!");
  }
  if(bindingResult.hasErrors()) {
   model.setViewName("user/signupMentor");
  } else {
   userService.saveMentor(user);
   model.addObject("msg", "User has been registered successfully! Now you can login.");
   model.addObject("user", new User());
   model.setViewName("user/signupMentor");
  }
  
  return model;
 }
 
 
 //dodawanie admina
 
 
 @RequestMapping(value= {"/signup_admin"}, method=RequestMethod.POST)
 public ModelAndView createAdmin(@Valid User user, BindingResult bindingResult) {
  ModelAndView model = new ModelAndView();
  User userExists = userService.findUserByEmail(user.getEmail());
  
  if(userExists != null) {
   bindingResult.rejectValue("email", "error.user", "This email already exists!");
  }
  if(bindingResult.hasErrors()) {
   model.setViewName("user/signupAdmin");
  } else {
   userService.saveAdmin(user);
   model.addObject("msg", "Admin has been registered successfully! Now you can login.");
   model.addObject("user", new User());
   model.setViewName("user/signupAdmin");
  }
  
  return model;
 }
 @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
 public ModelAndView home() {
  ModelAndView model = new ModelAndView();
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  User user = userService.findUserByEmail(auth.getName());
  
  model.addObject("userFirstname", user.getFirstname());
  model.addObject("userLastname", user.getLastname());
  model.addObject("userEmail", user.getEmail());
  model.addObject("userRoles", user.getRoleNames());
  
  List<User> allUsers = userService.findAllOrderedByNameDescending();
  model.addObject("allUsers", allUsers);
  
  model.setViewName("home/home");
  return model;
 }
 
 @RequestMapping(value= {"/home/admin"}, method=RequestMethod.GET)
 public ModelAndView homeAdin() {
  ModelAndView model = new ModelAndView();
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  User user = userService.findUserByEmail(auth.getName());
  
  model.addObject("userFirstname", user.getFirstname());
  model.addObject("userLastname", user.getLastname());
  model.addObject("userEmail", user.getEmail());
  model.addObject("userRoles", user.getRoleNames());
  
  List<User> allUsers = userService.findAllOrderedByNameDescending();
  model.addObject("allUsers", allUsers);
  
  model.setViewName("home/admin");
  return model;
 }
 
 @Autowired
 private RoleRespository roleRespository;
 
 @Autowired
 private MatchingService matchingService;
 
 @SuppressWarnings("unlikely-arg-type")
 
@RequestMapping(value= {"/home/admin/matching"}, method=RequestMethod.GET)
 public ModelAndView matchingResult() {

  ModelAndView model = new ModelAndView();
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 
  List<PerfectMatch> matchedPairs = matchingService.findAll();
  model.addObject("matchedErasmusMentorPairs", matchedPairs);
  
  List<ErasmusInfo> unpairedErasmusStudents = userService.findUnpairedErasmusStudents();
  model.addObject("unpairedErasmusStudents", unpairedErasmusStudents);
  
  List<MentorInfo> unpairedMentors = userService.findUnpairedMentors();
  model.addObject("unpairedMentors", unpairedMentors);
  
  List<User> allErasmus = userService.findAllOrderedByNameDescending();
  model.addObject("allErasmus", allErasmus);
  model.setViewName("home/matching");
  return model;
 }
 
 
 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
 public ModelAndView accessDenied() {
  ModelAndView model = new ModelAndView();
  model.setViewName("errors/access_denied");
  return model;
 }
 @RequestMapping(value= {"/contact"}, method=RequestMethod.GET)
 public ModelAndView contactPage() {
  ModelAndView model = new ModelAndView();
  model.setViewName("contact/contact");
  return model;
 }
 /* @RequestMapping(value= {"/application_form"}, method=RequestMethod.GET)
  public ModelAndView formPage() {
   ModelAndView model = new ModelAndView();
   model.setViewName("form/form_Erasmus");
   return model;
 }*/
/*  @RequestMapping(value= {"/assign_erasmus"}, method=RequestMethod.GET)
  public ModelAndView assignForm() {
   ModelAndView model = new ModelAndView();
   model.setViewName("form/form_Mentor");
   return model;
 }*/
  @GetMapping("/showUserList")
  public String findAllOrderedByNameDescending(Model model) {
	  
      List<User> users = (List<User>) userService.findAllOrderedByNameDescending();
      
      model.addAttribute("users", users);
      
      return "userDetails";
  }
  
  @RequestMapping(value= {"/admin"}, method=RequestMethod.GET)
  public ModelAndView adminView() {
   ModelAndView modelAndView = new ModelAndView();
   List<User> users = (List<User>) userService.findAllOrderedByNameDescending();
   modelAndView.addObject("users", users);
   modelAndView.setViewName("home/admin");
   return modelAndView;

  }
}