package org.mazz.rombooservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.mazz.rombooservice.constant.QueryConstants;
import org.mazz.rombooservice.custommodal.RoomStatusCustomModal;
import org.mazz.rombooservice.custommodal.RoomTotalStatusCustomModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RoomServiceImpl implements RoomService  {
	
	
	
	 private final  NamedParameterJdbcTemplate jdbcTemplate;
	 
		
	 @Autowired RoomServiceImpl(NamedParameterJdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate; }
	
	@Transactional(readOnly = true)
	@Override
	public List<RoomStatusCustomModal> getCurrentRoomStatus() {
		
		List<RoomStatusCustomModal> searchResults = null;

		
			searchResults = jdbcTemplate.query(QueryConstants.ROOM_STATUS1, new BeanPropertyRowMapper<>(RoomStatusCustomModal.class));
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

		
		totalRoomStatus = jdbcTemplate.query(QueryConstants.TOTAL_ROOM_STATUS, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
			
		totalRoomPax = jdbcTemplate.query(QueryConstants.TOTAL_ROOM_PAX, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
		totalTodayArr = jdbcTemplate.query(QueryConstants.TODAY_ARR, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
		totalTodayDep = jdbcTemplate.query(QueryConstants.TODAY_DEP, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
		dayUse = jdbcTemplate.query(QueryConstants.TODAY_USE, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
		continueRooms = jdbcTemplate.query(QueryConstants.TOTAL_CONTINUE_ROOM, new BeanPropertyRowMapper<>(RoomTotalStatusCustomModal.class));
		
		
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
