package org.mazz.rombooservice.repository;




import org.mazz.rombooservice.entity.SettleMast;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SettleMastRepository extends JpaRepository<SettleMast, Long> {
	

	
}