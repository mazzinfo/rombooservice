package org.mazz.rombooservice.repository;


import org.mazz.rombooservice.entity.SettleLine;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SettleLineRepository extends JpaRepository<SettleLine, Integer> {

}