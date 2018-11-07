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
		
		Optional<ErasmusInfo> erasmusInfoOptional = erasmusInfoRepository.findById(erasmusInfo.getUser().getId());
		
		if(erasmusInfoOptional.isPresent()) {
			//UPDATE
			ErasmusInfo erasmusInfoFromDb = erasmusInfoOptional.get();
			erasmusInfoFromDb.setErasmusName(erasmusInfo.getErasmusName());
			erasmusInfoFromDb.setErasmusSurname(erasmusInfo.getErasmusSurname());
			//TODO copy the remaining fields
			return erasmusInfoRepository.save(erasmusInfoFromDb);
		}else {
			//INSERT
			return erasmusInfoRepository.save(erasmusInfo);
		}
		
		
	}

}
