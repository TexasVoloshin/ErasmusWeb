package com.karolinawoloszyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karolinawoloszyn.model.ErasmusInfo;
@Repository("erasmusInfoRepository")
public interface ErasmusInfoRepository  extends JpaRepository<ErasmusInfo, Long>  {

}
