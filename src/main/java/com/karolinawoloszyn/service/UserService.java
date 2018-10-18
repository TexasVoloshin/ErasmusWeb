package com.karolinawoloszyn.service;

import com.karolinawoloszyn.model.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveErasmus(User user);
 public void saveMentor(User user);
 
}
