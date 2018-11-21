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

	@Override
	public PerfectMatch saveMentorErasmusPair(PerfectMatch perfectMatch) {
		// TODO Auto-generated method stub
		return null;
	}


	 

}
