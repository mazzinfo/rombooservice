package org.mazz.rombooservice.repository;

import org.mazz.rombooservice.entity.SettleHead;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SettleHeadRepository extends JpaRepository<SettleHead, Integer> {

}