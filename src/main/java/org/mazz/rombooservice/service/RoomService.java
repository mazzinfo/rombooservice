package org.mazz.rombooservice.service;

import java.util.List;

import org.mazz.rombooservice.custommodal.RoomStatusCustomModal;
import org.mazz.rombooservice.custommodal.RoomTotalStatusCustomModal;


public interface RoomService {
	
	
	List<RoomStatusCustomModal> getCurrentRoomStatus();
	
	RoomTotalStatusCustomModal getTotalRoomStatus();
	 

}
