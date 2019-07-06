package org.mazz.rombooservice.service;

import java.util.List;

import org.mazz.rombooservice.custommodal.RoomStatusCustomModal;
import org.mazz.rombooservice.custommodal.RoomTotalStatusCustomModal;
import org.mazz.rombooservice.custommodal.TodayBookingCustomModal;


public interface RoomService {
	
	
	List<RoomStatusCustomModal> getCurrentRoomStatus();
	
	List<TodayBookingCustomModal> getTodayBookingList();
	
	List<TodayBookingCustomModal> getBookingList();
	
	RoomTotalStatusCustomModal getTotalRoomStatus();
	 

}
