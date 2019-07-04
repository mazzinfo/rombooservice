package org.mazz.rombooservice.repository;

import org.mazz.rombooservice.entity.Advance;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AdvanceRepository extends JpaRepository<Advance, Integer> {

}