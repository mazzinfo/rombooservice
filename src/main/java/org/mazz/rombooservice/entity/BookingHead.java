package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the BookingHead database table.
 * 
 */
@Table(name = "bookinghead")
@Entity(name = "BookingHead")
@NamedQuery(name="BookingHead.findAll", query="SELECT b FROM BookingHead b")
public class BookingHead implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingpckey")
	private int bookingPcKey;

	@Column(name="active")
	private String active;

	@Column(name="advancepckey")
	private int advancePcKey;

	@Column(name="arrivalmode")
	private int arrivalMode;

	@Column(name="blocked")
	private String blocked;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="bookingdate")
	private java.util.Date bookingDate;

	@Column(name="bookingmode")
	private int bookingMode;

	@Column(name="bookingshiftcode")
	private int bookingShiftCode;

	@Column(name="cancelled")
	private boolean cancelled;

	@Column(name="compgust")
	private String compGust;

	@Column(name="guestid")
	private int guestId;

	@Column(name="noshow")
	private boolean noShow;

	@Column(name="shiftcode")
	private int shiftCode;

	@Column(name="shiftdate")
	private java.util.Date shiftDate;

	@Column(name="usercode")
	private int userCode;
	
	@Column(name="agentcode")
	private int AgentCode;

	

	public BookingHead() {
	}



	public int getBookingPcKey() {
		return bookingPcKey;
	}



	public void setBookingPcKey(int bookingPcKey) {
		this.bookingPcKey = bookingPcKey;
	}



	public String getActive() {
		return active;
	}



	public void setActive(String active) {
		this.active = active;
	}



	public int getAdvancePcKey() {
		return advancePcKey;
	}



	public void setAdvancePcKey(int advancePcKey) {
		this.advancePcKey = advancePcKey;
	}



	public int getArrivalMode() {
		return arrivalMode;
	}



	public void setArrivalMode(int arrivalMode) {
		this.arrivalMode = arrivalMode;
	}



	public String getBlocked() {
		return blocked;
	}



	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}



	public java.util.Date getBookingDate() {
		return bookingDate;
	}



	public void setBookingDate(java.util.Date bookingDate) {
		this.bookingDate = bookingDate;
	}



	public int getBookingMode() {
		return bookingMode;
	}



	public void setBookingMode(int bookingMode) {
		this.bookingMode = bookingMode;
	}



	public int getBookingShiftCode() {
		return bookingShiftCode;
	}



	public void setBookingShiftCode(int bookingShiftCode) {
		this.bookingShiftCode = bookingShiftCode;
	}



	public boolean isCancelled() {
		return cancelled;
	}



	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}



	public String getCompGust() {
		return compGust;
	}



	public void setCompGust(String compGust) {
		this.compGust = compGust;
	}



	public int getGuestId() {
		return guestId;
	}



	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}



	public boolean isNoShow() {
		return noShow;
	}



	public void setNoShow(boolean noShow) {
		this.noShow = noShow;
	}



	public int getShiftCode() {
		return shiftCode;
	}



	public void setShiftCode(int shiftCode) {
		this.shiftCode = shiftCode;
	}



	public java.util.Date getShiftDate() {
		return shiftDate;
	}



	public void setShiftDate(java.util.Date shiftDate) {
		this.shiftDate = shiftDate;
	}



	public int getUserCode() {
		return userCode;
	}



	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}



	public int getAgentCode() {
		return AgentCode;
	}



	public void setAgentCode(int agentCode) {
		AgentCode = agentCode;
	}

	
}