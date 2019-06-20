package org.mazz.rombooservice.service;

import java.util.List;


import org.mazz.rombooservice.custommodal.RoomStatusCustomModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RoomServiceImpl implements RoomService  {
	
	private static final String ROOM_STATUS ="SELECT  rt.typeName, rm.roomNo, rm.vacant, rm.underRepair, rm.floors, rm.checkInPcKey, rm.roomCode, rm.dirty, rm.srno,rm.crLimit, rci.dateTimeCheckin,rci.dateTimeCheckout,"
			+ " CASE WHEN (rm.dirty =1) THEN 'D' WHEN (rm.underRepair='Y') THEN 'U'  WHEN (rm.vacant=0) THEN 'I'  ELSE 'V' END as roomCurrentStatus,rci.guestName  " + 
			"FROM  RoomType rt INNER JOIN RoomMast rm ON rt.roomType = rm.roomType LEFT OUTER JOIN RoomCheckin rci ON rm.checkInPcKey = rci.checkinPcKey ORDER BY rm.roomNo";
	
	
	 private final  NamedParameterJdbcTemplate jdbcTemplate;
	 
		
	 @Autowired RoomServiceImpl(NamedParameterJdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate; }
	
	@Transactional(readOnly = true)
	@Override
	public List<RoomStatusCustomModal> getCurrentRoomStatus() {
		
		List<RoomStatusCustomModal> searchResults = null;

		
			searchResults = jdbcTemplate.query(ROOM_STATUS, new BeanPropertyRowMapper<>(RoomStatusCustomModal.class));
		return searchResults;
	}
	 

}
