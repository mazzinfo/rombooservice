package org.mazz.rombooservice.repository;

import org.mazz.rombooservice.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

}