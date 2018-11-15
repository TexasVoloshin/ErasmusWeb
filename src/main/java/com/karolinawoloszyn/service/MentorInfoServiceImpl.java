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
			mentorInfoFromDb.setMentor_email(mentorInfo.getMentor_email());
			mentorInfoFromDb.setMentor_gender(mentorInfo.getMentor_gender());
			mentorInfoFromDb.setMentor_uni(mentorInfo.getMentor_uni());
			mentorInfoFromDb.setMentor_tel(mentorInfo.getMentor_tel());
			mentorInfoFromDb.setMentor_studies(mentorInfo.getMentor_studies());
			mentorInfoFromDb.setMentor_facultyAGH(mentorInfo.getMentor_facultyAGH());
			mentorInfoFromDb.setMentor_countryOfErasmus(mentorInfo.getMentor_countryOfErasmus());
			//TODO copy the remaining fields
			return mentorInfoRepository.save(mentorInfoFromDb);
		}else {
			//INSERT
			mentorInfo.setUser(null);
			mentorInfo.setUserId(userId);
			return mentorInfoRepository.save(mentorInfo);
		}
		
		
	}

}
