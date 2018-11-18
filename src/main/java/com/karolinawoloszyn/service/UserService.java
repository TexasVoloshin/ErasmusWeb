package com.karolinawoloszyn.service;

import java.util.Collection;
import java.util.List;

import com.karolinawoloszyn.model.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveErasmus(User user);
 public void saveMentor(User user);
 public List<User> findAllOrderedByNameDescending();
 public void saveAdmin(User user);

/*public List<User> findAllErasmusOrderedByNameDescending();
*/



 
}
