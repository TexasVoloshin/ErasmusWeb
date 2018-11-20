package com.karolinawoloszyn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karolinawoloszyn.model.ErasmusInfo;
import com.karolinawoloszyn.model.MentorInfo;
@Repository("mentorInfoRepository")
public interface MentorInfoRepository  extends JpaRepository<MentorInfo, Integer>  {

	List<MentorInfo> findAllUnpaired();

}
