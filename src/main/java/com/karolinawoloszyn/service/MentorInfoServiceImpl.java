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
			mentorInfoFromDb.setMentorName(mentorInfo.getMentorName());
			mentorInfoFromDb.setMentorSurname(mentorInfo.getMentorSurname());
			mentorInfoFromDb.setMentorEmail(mentorInfo.getMentorEmail());
			mentorInfoFromDb.setMentorGender(mentorInfo.getMentorGender());
			mentorInfoFromDb.setMentorUni(mentorInfo.getMentorUni());
			mentorInfoFromDb.setMentorTel(mentorInfo.getMentorTel());
			mentorInfoFromDb.setMentorStudies(mentorInfo.getMentorStudies());
			mentorInfoFromDb.setMentorFacultyAGH(mentorInfo.getMentorFacultyAGH());
			mentorInfoFromDb.setMentorCountryOfErasmus(mentorInfo.getMentorCountryOfErasmus());
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
