package org.mazz.rombooservice.repository;




import javax.transaction.Transactional;

import org.mazz.rombooservice.entity.BookingHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingHeadRepository extends JpaRepository<BookingHead, Integer> {
	
	@Transactional
	 @Modifying
	 @Query("update BookingHead c set c.active=:active,c.cancelled=:cancelled WHERE c.bookingPcKey =:bookingPcKey")
    void updateBookingDelete(@Param("bookingPcKey") int bookingPcKey,@Param("active") String  active,@Param("cancelled") boolean cancelled);
	

	
}