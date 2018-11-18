package com.karolinawoloszyn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.karolinawoloszyn.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
 

User findByEmail(String email);
List<User> findAllOrderedByNameDescending();
/*List<User> findAllErasmusOrderedByNameDescending();
*/
 



}