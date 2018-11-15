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
			erasmusInfoFromDb.setErasmus_name(erasmusInfo.getErasmus_name());
			erasmusInfoFromDb.setErasmus_surname(erasmusInfo.getErasmus_surname());
			erasmusInfoFromDb.setErasmus_email(erasmusInfo.getErasmus_email());
			erasmusInfoFromDb.setErasmus_gender(erasmusInfo.getErasmus_gender());
			erasmusInfoFromDb.setErasmus_uni(erasmusInfo.getErasmus_uni());
			erasmusInfoFromDb.setErasmus_tel(erasmusInfo.getErasmus_tel());
			/*erasmusInfoFromDb.setErasmus_studies(erasmusInfo.getErasmus_studies());
			erasmusInfoFromDb.setErasmus_facultyAGH(erasmusInfo.getErasmus_facultyAGH());
			erasmusInfoFromDb.setErasmus_country(erasmusInfo.getErasmus_country());*/
			return erasmusInfoRepository.save(erasmusInfoFromDb);
		}else {
			//INSERT
			erasmusInfo.setUser(null);
			erasmusInfo.setUserId(userId);
			return erasmusInfoRepository.save(erasmusInfo);
		}
		
		
	}

}
