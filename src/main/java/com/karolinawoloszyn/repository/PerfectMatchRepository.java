package com.karolinawoloszyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karolinawoloszyn.model.MentorInfo;
import com.karolinawoloszyn.model.PerfectMatch;

@Repository("PerfectMatchRepository")
public interface PerfectMatchRepository  extends JpaRepository< PerfectMatch, Integer>  {

}

