package org.mazz.rombooservice.custommodal;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RoomStatusCustomModal {
	private String typeName;
	private String roomNo;
	private int vacant;
	private String underRepair;
	private int floors;
	private int checkInPcKey;
	private int roomCode;
	private int dirty;
	private String srNo;
	private int crLimit;
	private String dateTimeCheckin;
	private String dateTimeCheckout;
	private String roomCurrentStatus;
	private String guestName;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public int getVacant() {
		return vacant;
	}
	public void setVacant(int vacant) {
		this.vacant = vacant;
	}
	public String getUnderRepair() {
		return underRepair;
	}
	public void setUnderRepair(String underRepair) {
		this.underRepair = underRepair;
	}
	public int getFloors() {
		return floors;
	}
	public void setFloors(int floors) {
		this.floors = floors;
	}
	public int getCheckInPcKey() {
		return checkInPcKey;
	}
	public void setCheckInPcKey(int checkInPcKey) {
		this.checkInPcKey = checkInPcKey;
	}
	public int getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}
	public int getDirty() {
		return dirty;
	}
	public void setDirty(int dirty) {
		this.dirty = dirty;
	}
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	public int getCrLimit() {
		return crLimit;
	}
	public void setCrLimit(int crLimit) {
		this.crLimit = crLimit;
	}
	public String getDateTimeCheckin() {
		return dateTimeCheckin;
	}
	public void setDateTimeCheckin(String dateTimeCheckin) {
		this.dateTimeCheckin = dateTimeCheckin;
	}
	public String getDateTimeCheckout() {
		return dateTimeCheckout;
	}
	public void setDateTimeCheckout(String dateTimeCheckout) {
		this.dateTimeCheckout = dateTimeCheckout;
	}
	public String getRoomCurrentStatus() {
		return roomCurrentStatus;
	}
	public void setRoomCurrentStatus(String roomCurrentStatus) {
		this.roomCurrentStatus = roomCurrentStatus;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	
}
