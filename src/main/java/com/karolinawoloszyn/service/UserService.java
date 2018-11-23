package com.karolinawoloszyn.service;

import java.util.List;

import com.karolinawoloszyn.model.ErasmusInfo;
import com.karolinawoloszyn.model.MentorInfo;
import com.karolinawoloszyn.model.PerfectMatch;
import com.karolinawoloszyn.model.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveErasmus(User user);
 public void saveMentor(User user);
 public List<User> findAllOrderedByNameDescending();
 public void saveAdmin(User user);

public List<ErasmusInfo> findUnpairedErasmusStudents();

public List<MentorInfo> findUnpairedMentors();

public List<PerfectMatch> findAll();


/*public List<User> findAllErasmusOrderedByNameDescending();
*/



 
}
