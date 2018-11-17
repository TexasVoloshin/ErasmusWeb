package com.karolinawoloszyn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karolinawoloszyn.model.ErasmusInfo;
import com.karolinawoloszyn.repository.ErasmusInfoRepository;

@Service
public class ErasmusInfoServiceImpl implements ErasmusInfoService {

	@Autowired
	private ErasmusInfoRepository erasmusInfoRepository;

	@Override
	public ErasmusInfo saveErasmusInfo(ErasmusInfo erasmusInfo) {
		
		int userId = erasmusInfo.getUser().getId();
		Optional<ErasmusInfo> erasmusInfoOptional = erasmusInfoRepository.findById(userId);
		
		if(erasmusInfoOptional.isPresent()) {
			//UPDATE
			ErasmusInfo erasmusInfoFromDb = erasmusInfoOptional.get();
			erasmusInfoFromDb.setErasmusName(erasmusInfo.getErasmusName());
			erasmusInfoFromDb.setErasmusSurname(erasmusInfo.getErasmusSurname());
			erasmusInfoFromDb.setErasmusEmail(erasmusInfo.getErasmusEmail());
			erasmusInfoFromDb.setErasmusGender(erasmusInfo.getErasmusGender());
			erasmusInfoFromDb.setErasmusUni(erasmusInfo.getErasmusUni());
			erasmusInfoFromDb.setErasmusTel(erasmusInfo.getErasmusTel());
			erasmusInfoFromDb.setErasmusStudies(erasmusInfo.getErasmusStudies());
			erasmusInfoFromDb.setErasmusFacultyAGH(erasmusInfo.getErasmusFacultyAGH());
			erasmusInfoFromDb.setErasmusCountry(erasmusInfo.getErasmusCountry());
			return erasmusInfoRepository.save(erasmusInfoFromDb);
		}else {
			//INSERT
			erasmusInfo.setUser(null);
			erasmusInfo.setUserId(userId);
			return erasmusInfoRepository.save(erasmusInfo);
		}
		
		
	}

}
