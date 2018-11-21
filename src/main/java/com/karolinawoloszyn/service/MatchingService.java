package com.karolinawoloszyn.service;

import java.util.List;

import com.karolinawoloszyn.model.PerfectMatch;

public interface MatchingService {
	public List<PerfectMatch> findAll();

	PerfectMatch saveMentorErasmusPair(PerfectMatch perfectMatch);

//	public Object findUserByEmail(String email);
}
