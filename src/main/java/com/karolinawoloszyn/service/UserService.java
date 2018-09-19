package com.karolinawoloszyn.service;

import com.karolinawoloszyn.model.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveUser(User user);
}