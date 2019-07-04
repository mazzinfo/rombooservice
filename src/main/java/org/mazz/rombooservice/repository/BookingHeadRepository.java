package org.mazz.rombooservice.repository;




import org.mazz.rombooservice.entity.BookingHead;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookingHeadRepository extends JpaRepository<BookingHead, Integer> {
	

	
}