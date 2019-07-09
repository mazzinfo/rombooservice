package org.mazz.rombooservice.repository;

import org.mazz.rombooservice.entity.BookingLine;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookingLineRepository extends JpaRepository<BookingLine, Integer> {

}