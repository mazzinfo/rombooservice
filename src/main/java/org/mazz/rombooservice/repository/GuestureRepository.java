package org.mazz.rombooservice.repository;


import java.util.List;
import java.util.Optional;

import org.mazz.rombooservice.entity.GuestMast;
import org.mazz.rombooservice.entity.Guesture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestureRepository extends JpaRepository<Guesture, Integer> {
	

	 @Query("FROM Guesture t where t.description = :description")     
		Optional<List<Guesture>> getGuestereByDesc( @Param("description") String description);
	
}