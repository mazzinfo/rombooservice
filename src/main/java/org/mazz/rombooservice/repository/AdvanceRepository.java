package org.mazz.rombooservice.repository;

import java.util.List;
import java.util.Optional;

import org.mazz.rombooservice.entity.Advance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvanceRepository extends JpaRepository<Advance, Integer> {
	
	 @Query("FROM Advance t where t.bookingPcKey = :bookingPcKey")     
		Optional<List<Advance>> getAdavanceByBookingId( @Param("bookingPcKey") String bookingPcKey);
	 

}