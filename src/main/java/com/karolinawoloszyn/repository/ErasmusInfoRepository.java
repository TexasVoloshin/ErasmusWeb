package com.karolinawoloszyn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karolinawoloszyn.model.ErasmusInfo;
@Repository("erasmusInfoRepository")
public interface ErasmusInfoRepository  extends JpaRepository<ErasmusInfo, Integer>  {

	List<ErasmusInfo> findAllUnpaired();

}
