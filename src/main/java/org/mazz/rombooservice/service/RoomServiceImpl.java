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
	
	private static final String ROOM_STATUS ="SELECT  rt.typeName, rm.roomNo, rm.vacant, rm.underRepair, rm.floors, rm.checkInPcKey, rm.roomCode, rm.dirty, rm.srno,rm.crLimit, rci.dateTimeCheckin,"
			+ "(select dateTimeCheckout from RoomCheckin rrm where rrm.currentRoomCode=rm.roomCode and rm.vacant=0  )  as currentDateTimeCheckout,"
			+ " CASE WHEN (rm.dirty =1) THEN 'D' WHEN (rm.underRepair='Y') THEN 'U'  WHEN (rm.vacant=0) THEN 'I'  ELSE 'V' END as roomCurrentStatus,rci.guestName  " + 
			"FROM  RoomType rt INNER JOIN RoomMast rm ON rt.roomType = rm.roomType LEFT OUTER JOIN RoomCheckin rci ON rm.checkInPcKey = rci.checkinPcKey ORDER BY rm.roomNo";
	
	
	private static final String ROOM_STATUS1 ="SELECT   (SELECT typeName from RoomType rt where rt.roomType = rm.roomType ) typeName, rm.roomNo, rm.vacant, rm.underRepair, rm.floors, rm.checkInPcKey, rm.roomCode, rm.dirty, rm.srno,rm.crLimit,"
			+ " (SELECT dateTimeCheckin from RoomCheckin rci where rci.checkinPcKey = rm.checkInPcKey ) as dateTimeCheckin,(SELECT guestName from RoomCheckin rci where rci.checkinPcKey = rm.checkInPcKey ) as guestName, "
			+ "(SELECT DISTINCT TOP 1 dateTimeCheckout from RoomCheckin rci where rci.currentRoomCode = rm.roomCode and rm.vacant !=0  ORDER BY  rci.dateTimeCheckout DESC ) as dateTimeCheckout,"
			+ " CASE WHEN (rm.dirty =1) THEN 'D' WHEN (rm.underRepair='Y') THEN 'U'  WHEN (rm.vacant=0) THEN 'I'  ELSE 'V' END as roomCurrentStatus " 
			+ "FROM RoomMast rm ";
	
	private static final String ROOM_STATUS2="SELECT DISTINCT TOP 1  rm.roomNo, rci.dateTimeCheckout FROM RoomType rt INNER JOIN RoomMast rm ON rt.RoomType = rm.RoomType INNER JOIN RoomCheckin rci ON rm.RoomCode = rci.CurrentRoomCode\r\n" + 
			"WHERE  rm.Vacant != 0  ORDER BY  rci.DateTimeCheckout DESC";
	
	
	
	
	
	 private final  NamedParameterJdbcTemplate jdbcTemplate;
	 
		
	 @Autowired RoomServiceImpl(NamedParameterJdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate; }
	
	@Transactional(readOnly = true)
	@Override
	public List<RoomStatusCustomModal> getCurrentRoomStatus() {
		
		List<RoomStatusCustomModal> searchResults = null;

		
			searchResults = jdbcTemplate.query(ROOM_STATUS1, new BeanPropertyRowMapper<>(RoomStatusCustomModal.class));
		return searchResults;
	}
	 

}
