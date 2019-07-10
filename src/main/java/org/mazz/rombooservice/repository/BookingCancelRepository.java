package org.mazz.rombooservice.repository;

import org.mazz.rombooservice.entity.BookingCancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingCancelRepository extends JpaRepository<BookingCancel, Integer> {
	

	 

}