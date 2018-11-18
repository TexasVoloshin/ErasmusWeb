package com.karolinawoloszyn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.karolinawoloszyn.model.Role;
import com.karolinawoloszyn.model.User;
import com.karolinawoloszyn.repository.RoleRespository;
import com.karolinawoloszyn.repository.UserRepository;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService {
 
 @Autowired
 private UserRepository userRepository;
 
 @Autowired
 private RoleRespository roleRespository;
 
 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Override
 public User findUserByEmail(String email) {
  return userRepository.findByEmail(email);
 }
//zrobic jedna metodesave
 @Override
 public void saveErasmus(User user) {
  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
  user.setActive(1);
  Role userRole = roleRespository.findByRole("ERASMUS");
  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
  userRepository.save(user);
 }
 @Override
 public void saveMentor(User user) {
  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
  user.setActive(1);
  Role userRole = roleRespository.findByRole("MENTOR");
  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
  userRepository.save(user);
 }
 @Override
 public void saveAdmin(User user) {
  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
  user.setActive(1);
  Role userRole = roleRespository.findByRole("ADMIN");
  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
  userRepository.save(user);
 }
 @Override
 public List<User> findAllOrderedByNameDescending() {

     List<User> user = (List<User>) userRepository.findAllOrderedByNameDescending();
     return user;
 }


 /*@Override
 @Query(value = "SELECT *\r\n" + 
	  		"  FROM `Erasmus`.`user` EU LEFT JOIN `Erasmus`.`user_role` ER ON  EU.id =  ER.user_id\r\n" + 
	  		"  where ER.role_id = 3\r\n" + 
	  		" ", 
	  nativeQuery = true)
 
   public List<User> findAllErasmusOrderedByNameDescending() {
 
     List<User> user = (List<User>) userRepository.findAllErasmusOrderedByNameDescending(String firstName, String LastName, String Role);
     return user;
 }*/
 
}
