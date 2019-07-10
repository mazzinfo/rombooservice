package org.mazz.rombooservice.repository;

import java.util.List;
import java.util.Optional;

import org.mazz.rombooservice.entity.Advance;
import org.mazz.rombooservice.entity.SettleHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SettleHeadRepository extends JpaRepository<SettleHead, Integer> {

	 @Query("FROM SettleHead t where t.settlePcKey = :settlePcKey")     
		Optional<List<SettleHead>> getSettleListById( @Param("settlePcKey") int settlePcKey);

	
}