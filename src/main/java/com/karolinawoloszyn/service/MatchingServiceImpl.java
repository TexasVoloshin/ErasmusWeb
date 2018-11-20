package com.karolinawoloszyn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karolinawoloszyn.model.PerfectMatch;
import com.karolinawoloszyn.repository.PerfectMatchRepository;

@Service("perfectMatchService")
public class MatchingServiceImpl implements MatchingService {

	@Autowired
	private PerfectMatchRepository perfectMatchRepository;

	@Override
	public List<PerfectMatch> findAll() {
		return perfectMatchRepository.findAll();
	}

	/*
	 * 
	 * @Override public PerfectMatch saveMentorErasmusPair(PerfectMatch
	 * perfectMatch) {
	 * 
	 * int userId = mentorInfo.getUser().getId(); Optional<MentorInfo>
	 * mentorInfoOptional = mentorInfoRepository.findById(userId);
	 * 
	 * if(mentorInfoOptional.isPresent()) { //UPDATE MentorInfo mentorInfoFromDb =
	 * mentorInfoOptional.get();
	 * mentorInfoFromDb.setMentorName(mentorInfo.getMentorName());
	 * 
	 * //TODO copy the remaining fields return
	 * mentorInfoRepository.save(mentorInfoFromDb); }else { //INSERT
	 * mentorInfo.setUser(null); mentorInfo.setUserId(userId); return
	 * mentorInfoRepository.save(mentorInfo); }
	 * 
	 * 
	 */

}
