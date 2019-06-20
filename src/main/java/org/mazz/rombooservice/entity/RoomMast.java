package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the RoomMast database table.
 * 
 */
@Table(name = "roommast")
@Entity(name = "RoomMast")
@NamedQuery(name = "RoomMast.findAll", query = "SELECT r FROM RoomMast r")
public class RoomMast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roomcode")
	private int roomCode;

	@Column(name = "RoomNo")
	private String roomNo;

	@Column(name = "RoomType")
	private String roomType;

	@Column(name = "floors")
	private int floors;

	@Column(name = "maxpersons")
	private int maxPersons;

	@Column(name = "sharing")
	private int sharing;

	@Column(name = "teleextnno")
	private int teleExtnNo;

	@Column(name = "vacant")
	private int vacant;

	@Column(name = "undercheckout")
	private String underCheckout;

	@Column(name = "misrentamount")
	private BigDecimal misRentAmount;

	@Column(name = "checkinpckey")
	private int checkInPcKey;

	@Column(name = "mrMrs")
	private String mrMrs;

	@Column(name = "RoomHead")
	private String roomHead;

	@Column(name = "UnderRepair")
	private String underRepair;

	@Column(name = "dirty")
	private int dirty;

	@Column(name = "roomcheckout")
	private int roomCheckout;

	@Column(name = "srno")
	private String srNo;

	@Column(name = "crlimit")
	private int crLimit;

	public RoomMast() {
	}

	public int getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public int getMaxPersons() {
		return maxPersons;
	}

	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}

	public int getSharing() {
		return sharing;
	}

	public void setSharing(int sharing) {
		this.sharing = sharing;
	}

	public int getTeleExtnNo() {
		return teleExtnNo;
	}

	public void setTeleExtnNo(int teleExtnNo) {
		this.teleExtnNo = teleExtnNo;
	}

	public int getVacant() {
		return vacant;
	}

	public void setVacant(int vacant) {
		this.vacant = vacant;
	}

	public String getUnderCheckout() {
		return underCheckout;
	}

	public void setUnderCheckout(String underCheckout) {
		this.underCheckout = underCheckout;
	}

	public BigDecimal getMisRentAmount() {
		return misRentAmount;
	}

	public void setMisRentAmount(BigDecimal misRentAmount) {
		this.misRentAmount = misRentAmount;
	}

	public int getCheckInPcKey() {
		return checkInPcKey;
	}

	public void setCheckInPcKey(int checkInPcKey) {
		this.checkInPcKey = checkInPcKey;
	}

	public String getMrMrs() {
		return mrMrs;
	}

	public void setMrMrs(String mrMrs) {
		this.mrMrs = mrMrs;
	}

	public String getRoomHead() {
		return roomHead;
	}

	public void setRoomHead(String roomHead) {
		this.roomHead = roomHead;
	}

	public String getUnderRepair() {
		return underRepair;
	}

	public void setUnderRepair(String underRepair) {
		this.underRepair = underRepair;
	}

	public int getDirty() {
		return dirty;
	}

	public void setDirty(int dirty) {
		this.dirty = dirty;
	}

	public int getRoomCheckout() {
		return roomCheckout;
	}

	public void setRoomCheckout(int roomCheckout) {
		this.roomCheckout = roomCheckout;
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

	

	
}