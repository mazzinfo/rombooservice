package org.mazz.rombooservice.repository;



import org.mazz.rombooservice.entity.ArrivalMast;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ArrivalMastRepository extends JpaRepository<ArrivalMast, Long> {
	

	
}