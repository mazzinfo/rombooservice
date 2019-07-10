package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ArrivalMast database table.
 * 
 */
@Table(name = "bookingcancel")
@Entity(name = "BookingCancel")
@NamedQuery(name="BookingCancel.findAll", query="SELECT a FROM BookingCancel a")
public class BookingCancel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pckey")
	private int pckey;

	@Column(name = "bookingpckey")
	private int bookingPcKey;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="canceldate")
	private java.util.Date cancelDate;
	
	@Column(name = "reason")
	private String reason;
	@Column(name="shiftcode")
	private int shiftCode;

	@Column(name="shiftdate")
	private java.util.Date shiftDate;

	@Column(name="usercode")
	private int userCode;

	public BookingCancel() {
	}

	public int getPckey() {
		return pckey;
	}

	public void setPckey(int pckey) {
		this.pckey = pckey;
	}

	public int getBookingPcKey() {
		return bookingPcKey;
	}

	public void setBookingPcKey(int bookingPcKey) {
		this.bookingPcKey = bookingPcKey;
	}

	public java.util.Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	

	
}