package org.mazz.rombooservice.repository;



import java.util.List;
import java.util.Optional;


import org.mazz.rombooservice.entity.GuestMast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestMastRepository extends JpaRepository<GuestMast, Long> {
	
	 @Query("FROM GuestMast t where t.guestName = :guestName")     
		Optional<List<GuestMast>> getGuestList( @Param("guestName") String guestName);
	 
	 
	 

	
}