package org.mazz.rombooservice.repository;


import java.util.List;
import java.util.Optional;

import org.mazz.rombooservice.entity.SettleHead;
import org.mazz.rombooservice.entity.SettleLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SettleLineRepository extends JpaRepository<SettleLine, Integer> {
	
	 @Query("FROM SettleLine t where t.settlePcKey = :settlePcKey")     
		Optional<List<SettleLine>> getSettleListById( @Param("settlePcKey") int settlePcKey);

}