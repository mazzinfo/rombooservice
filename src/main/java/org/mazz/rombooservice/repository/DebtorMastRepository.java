package org.mazz.rombooservice.repository;



import org.mazz.rombooservice.entity.DebtorMast;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DebtorMastRepository extends JpaRepository<DebtorMast, Long> {
	

	
}