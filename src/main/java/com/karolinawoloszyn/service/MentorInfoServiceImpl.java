package com.karolinawoloszyn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.karolinawoloszyn.model.MentorInfo;
import com.karolinawoloszyn.repository.MentorInfoRepository;

@Service
public class MentorInfoServiceImpl implements MentorInfoService {

	@Autowired
	private MentorInfoRepository mentorInfoRepository;

	@Override
	public MentorInfo saveMentorInfo(MentorInfo mentorInfo) {
		
		int userId = mentorInfo.getUser().getId();
		Optional<MentorInfo> mentorInfoOptional = mentorInfoRepository.findById(userId);
		
		if(mentorInfoOptional.isPresent()) {
			//UPDATE
			MentorInfo mentorInfoFromDb = mentorInfoOptional.get();
			mentorInfoFromDb.setMentor_name(mentorInfo.getMentor_name());
			mentorInfoFromDb.setMentor_surname(mentorInfo.getMentor_surname());
			
			//TODO copy the remaining fields
			return mentorInfoRepository.save(mentorInfoFromDb);
		}else {
			//INSERT
			MentorInfo.setUser(null);
			MentorInfo.setUserId(userId);
			return mentorInfoRepository.save(mentorInfo);
		}
		
		
	}

}
