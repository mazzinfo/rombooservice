package org.mazz.rombooservice.repository;


import org.mazz.rombooservice.entity.Guesture;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface GuestureRepository extends JpaRepository<Guesture, Long> {
	

	
}