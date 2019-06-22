package org.mazz.rombooservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


import org.mazz.rombooservice.custommodal.RoomStatusCustomModal;
import org.mazz.rombooservice.custommodal.RoomTotalStatusCustomModal;
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
	
	
	
	private static final String TOTAL_ROOM_STATUS="SELECT count(*) as totalRooms, sum( CASE WHEN rm.vacant = 1 AND rm.underrepair = 'N' AND rm.dirty = 0 THEN 1 ELSE 0 END) AS vacant,  sum( CASE WHEN rm.vacant = 1 OR rm.underrepair = 'Y' THEN 0 ELSE 1 END) AS occupied," + 
			" sum( CASE WHEN rm.underRepair = 'Y' THEN 1 ELSE 0 END) AS blocked, sum( CASE WHEN rm.dirty = 1 THEN 1 ELSE 0 END) AS dirty FROM   RoomMast rm";
	
	private static final String TOTAL_ROOM_PAX="SELECT DISTINCT  SUM(ISNULL(rci.AdultsMale + rci.AdultsFemale, '')) AS totalPax, SUM(rci.AdultsMale) AS totalMale," + 
			"SUM(rci.AdultsFemale) AS totalFemale, SUM(rci.Children) AS totalChild, SUM(rci.ExtraPerson) AS exBed " + 
			"FROM  RoomMast rm INNER JOIN RoomCheckin rci ON rm.CheckInPcKey = rci.CheckinPcKey AND rm.RoomCode = rci.CurrentRoomCode WHERE  rm.Vacant = 0";
	
	
	
	private static final String TODAY_ARR="SELECT  count(*) as totalArr  FROM  RoomMast rm INNER JOIN RoomCheckin rci ON rm.CheckInPcKey = rci.CheckinPcKey " + 
			"WHERE rci.ChkInDt =CONVERT(date,GETDATE())";
	
	
	private static final String TOTAL_CONTINUE_ROOM="SELECT  count(*) as totalContinueRoom  FROM  RoomMast rm INNER JOIN RoomCheckin rci ON rm.CheckInPcKey = rci.CheckinPcKey " + 
			"WHERE rci.ChkInDt !=CONVERT(date,GETDATE()) and rci.chkOutDt ='' ";
	
	
	
	
	private static final String TODAY_DEP="SELECT  count(*) as todayDep  FROM   RoomCheckin rci  " + 
			"WHERE rci.chkOutDt =CONVERT(date,GETDATE())";
	
	private static final String TODAY_USE="SELECT  count(*) as dayUse  FROM   RoomCheckin rci  " + 
			"WHERE rci.ChkInDt =CONVERT(date,GETDATE()) and rci.chkOutDt =CONVERT(date,GETDATE())";
	
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
	
	@Transactional(readOnly = true)
	@Override
	public RoomTotalStatusCustomModal getTotalRoomStatus() {
		
		List<RoomTotalStatusCustomModal> totalRoomStatus = null;
		List<RoomTotalStatusCustomModal> totalRoomPax = null;
		List<RoomTotalStatusCustomModal> totalTodayArr = null;
		List<RoomTotalStatusCustomModal> totalTodayDep = null;
		List<RoomTotalStatusCustomModal> dayUse = null;
		List<RoomTotalStatusCustomModal> continueRooms = null;
		
		RoomTotalStatusCustomModal totalResult=new RoomTotalStatusCustomModal();

		
		totalRoomStatus = jdbcTemplate.query(TOTAL_ROOM_STATUS, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
			
		totalRoomPax = jdbcTemplate.query(TOTAL_ROOM_PAX, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
		totalTodayArr = jdbcTemplate.query(TODAY_ARR, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
		totalTodayDep = jdbcTemplate.query(TODAY_DEP, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
		dayUse = jdbcTemplate.query(TODAY_USE, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
		continueRooms = jdbcTemplate.query(TOTAL_CONTINUE_ROOM, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
		
		
		//BigDecimal occPer=(new BigDecimal(totalRoomStatus.get(0).getTotalRooms()).divide(new BigDecimal(100)).multiply(new BigDecimal(totalRoomStatus.get(0).getTotalRooms())));
		
		BigDecimal occPer=(new BigDecimal(totalRoomStatus.get(0).getOccupied()).multiply(new BigDecimal(100)).divide(new BigDecimal(totalRoomStatus.get(0).getTotalRooms()),2, RoundingMode.HALF_UP));
			
		
		
		
		totalResult.setBlocked(totalRoomStatus.get(0).getBlocked());
		totalResult.setDayUse(dayUse.get(0).getDayUse());
		totalResult.setDirty(totalRoomStatus.get(0).getDirty());
		totalResult.setExBed(totalRoomPax.get(0).getExBed());
		totalResult.setOccPer(""+occPer);
		totalResult.setOccupied(totalRoomStatus.get(0).getOccupied());
		totalResult.setTodayDep(totalTodayDep.get(0).getTodayDep());
		totalResult.setTotalArr(totalTodayArr.get(0).getTotalArr());
		totalResult.setTotalChild(totalRoomPax.get(0).getTotalChild());
		totalResult.setTotalFemale(totalRoomPax.get(0).getTotalFemale());
		totalResult.setTotalMale(totalRoomPax.get(0).getTotalMale());
		totalResult.setTotalPax(totalRoomPax.get(0).getTotalPax());
		totalResult.setTotalRooms(totalRoomStatus.get(0).getTotalRooms());
		totalResult.setVacant(totalRoomStatus.get(0).getVacant());
		totalResult.setTotalContinueRoom(continueRooms.get(0).getTotalContinueRoom());
			
		return totalResult;
	}
	 

}
