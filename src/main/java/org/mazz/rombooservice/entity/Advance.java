package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;


/**
 * The persistent class for the AdvanceCollections database table.
 * 
 */
@Table(name = "advance")
@Entity(name = "Advance")
@NamedQuery(name="Advance.findAll", query="SELECT a FROM Advance a")
public class Advance implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "advancepckey")
	private int advancePcKey;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dttime")
	private java.util.Date dtTime;

	@Column(name="Amount")
	private BigDecimal amount;
		
	@Column(name="billno")
	private String billNo;
	@Column(name="receiptno")
	private String receiptNo;
	
	@Column(name="settlepckey")
	private String settlePckey;
	
	@Column(name="checkinpckey")
	private String checkInPckey;
	
	@Column(name="roomcode")
	private String roomCode;
	
	@Column(name="billpckey")
	private String billPckey;
	
	@Column(name = "bookingpckey")
	private String bookingPcKey;
	
	@Column(name = "advtransid")
	private String advTransId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="advtransdate")
	private java.util.Date advTransDate;
	

	public Advance() {
	}


	public int getAdvancePcKey() {
		return advancePcKey;
	}


	public void setAdvancePcKey(int advancePcKey) {
		this.advancePcKey = advancePcKey;
	}


	public java.util.Date getDtTime() {
		return dtTime;
	}


	public void setDtTime(java.util.Date dtTime) {
		this.dtTime = dtTime;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public String getBillNo() {
		return billNo;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	public String getReceiptNo() {
		return receiptNo;
	}


	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}


	public String getSettlePckey() {
		return settlePckey;
	}


	public void setSettlePckey(String settlePckey) {
		this.settlePckey = settlePckey;
	}


	public String getCheckInPckey() {
		return checkInPckey;
	}


	public void setCheckInPckey(String checkInPckey) {
		this.checkInPckey = checkInPckey;
	}


	public String getRoomCode() {
		return roomCode;
	}


	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}


	public String getBillPckey() {
		return billPckey;
	}


	public void setBillPckey(String billPckey) {
		this.billPckey = billPckey;
	}


	public String getBookingPcKey() {
		return bookingPcKey;
	}


	public void setBookingPcKey(String bookingPcKey) {
		this.bookingPcKey = bookingPcKey;
	}


	public String getAdvTransId() {
		return advTransId;
	}


	public void setAdvTransId(String advTransId) {
		this.advTransId = advTransId;
	}


	public java.util.Date getAdvTransDate() {
		return advTransDate;
	}


	public void setAdvTransDate(java.util.Date advTransDate) {
		this.advTransDate = advTransDate;
	}


	
	
}