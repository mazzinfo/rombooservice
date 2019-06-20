package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * The persistent class for the RoomCheckin database table.
 * 
 */
@Table(name = "roomcheckin")
@Entity(name = "RoomCheckin")
@NamedQuery(name = "RoomCheckin.findAll", query = "SELECT r FROM RoomCheckin r")
public class RoomCheckin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "checkipckey")
	private int checkinPcKey;

	@Column(name = "guestid")
	private int guestId;

	@Column(name = "roomcode")
	private int roomCode;

	@Column(name = "businesstype")
	private String businessType;

	@Column(name = "segmenttype")
	private String segmentType;

	@Column(name = "plancode")
	private int planCode;

	@Column(name = "smsdate")
	private Date smsDate;

	@Column(name = "datetimecheckin")
	private Date dateTimeCheckin;

	@Column(name = "chkindt")
	private Date chkInDt;

	@Column(name = "datetimecheckout")
	private Date dateTimeCheckout;

	@Column(name = "chkoutdt")
	private Date chkOutDt;

	@Column(name = "adultsmale")
	private int adultsMale;

	@Column(name = "adultsfemale")
	private int adultsFemale;

	@Column(name = "children")
	private int children;

	@Column(name = "extraperson")
	private int extraPerson;

	@Column(name = "checkintype")
	private int checkinType;

	@Column(name = "billno")
	private String billNo;

	@Column(name = "rentcode")
	private int rentCode;

	@Column(name = "agentcode")
	private int agentCode;
	@Column(name = "commbyamount")
	private int commByAmount;

	@Column(name = "bookingpckey")
	private int bookingPckey;

	@Column(name = "likelyout")
	private Date likelyOut;

	@Column(name = "expchkout")
	private Date expChkOut;

	@Column(name = "advancepckey")
	private int advancePcKey;

	@Column(name = "currentroomcode")
	private int currentRoomCode;

	@Column(name = "grcnumber")
	private int grcNumber;

	@Column(name = "purpose")
	private String purpose;
	@Column(name = "shiftcode")
	private int shiftCode;

	@Column(name = "shiftdate")
	private Date shiftDate;

	@Column(name = "billpckey")
	private int billPckey;
	@Column(name = "checkinrent")
	private int checkInRent;
	@Column(name = "discountrate")
	private BigDecimal discountRate;

	@Column(name = "discountbypercent")
	private int discountByPercent;

	@Column(name = "usercode")
	private int userCode;

	@Column(name = "discountperday")
	private int discountPerDay;

	@Column(name = "doubleoccrent")
	private int doubleOccRent;
	@Column(name = "mrmrs")
	private String mrMrs;
	@Column(name = "guestname")
	private String guestName;

	@Column(name = "creditlimit")
	private BigDecimal creditLimit;

	@Column(name = "corpbooingid")
	private String corpBooingId;

	@Column(name = "compgstno")
	private String compGstNo;

	@Column(name = "transactionId")
	private String transactionId;

	@Column(name = "transactiondate")
	private String transactionDate;

	@Column(name = "instrfo")
	private String instrFo;

	public int getCheckinPcKey() {
		return checkinPcKey;
	}

	public void setCheckinPcKey(int checkinPcKey) {
		this.checkinPcKey = checkinPcKey;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public int getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getSegmentType() {
		return segmentType;
	}

	public void setSegmentType(String segmentType) {
		this.segmentType = segmentType;
	}

	public int getPlanCode() {
		return planCode;
	}

	public void setPlanCode(int planCode) {
		this.planCode = planCode;
	}

	public Date getSmsDate() {
		return smsDate;
	}

	public void setSmsDate(Date smsDate) {
		this.smsDate = smsDate;
	}

	public Date getDateTimeCheckin() {
		return dateTimeCheckin;
	}

	public void setDateTimeCheckin(Date dateTimeCheckin) {
		this.dateTimeCheckin = dateTimeCheckin;
	}

	public Date getChkInDt() {
		return chkInDt;
	}

	public void setChkInDt(Date chkInDt) {
		this.chkInDt = chkInDt;
	}

	public Date getDateTimeCheckout() {
		return dateTimeCheckout;
	}

	public void setDateTimeCheckout(Date dateTimeCheckout) {
		this.dateTimeCheckout = dateTimeCheckout;
	}

	public Date getChkOutDt() {
		return chkOutDt;
	}

	public void setChkOutDt(Date chkOutDt) {
		this.chkOutDt = chkOutDt;
	}

	public int getAdultsMale() {
		return adultsMale;
	}

	public void setAdultsMale(int adultsMale) {
		this.adultsMale = adultsMale;
	}

	public int getAdultsFemale() {
		return adultsFemale;
	}

	public void setAdultsFemale(int adultsFemale) {
		this.adultsFemale = adultsFemale;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getExtraPerson() {
		return extraPerson;
	}

	public void setExtraPerson(int extraPerson) {
		this.extraPerson = extraPerson;
	}

	public int getCheckinType() {
		return checkinType;
	}

	public void setCheckinType(int checkinType) {
		this.checkinType = checkinType;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public int getRentCode() {
		return rentCode;
	}

	public void setRentCode(int rentCode) {
		this.rentCode = rentCode;
	}

	public int getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(int agentCode) {
		this.agentCode = agentCode;
	}

	public int getCommByAmount() {
		return commByAmount;
	}

	public void setCommByAmount(int commByAmount) {
		this.commByAmount = commByAmount;
	}

	public int getBookingPckey() {
		return bookingPckey;
	}

	public void setBookingPckey(int bookingPckey) {
		this.bookingPckey = bookingPckey;
	}

	public Date getLikelyOut() {
		return likelyOut;
	}

	public void setLikelyOut(Date likelyOut) {
		this.likelyOut = likelyOut;
	}

	public Date getExpChkOut() {
		return expChkOut;
	}

	public void setExpChkOut(Date expChkOut) {
		this.expChkOut = expChkOut;
	}

	public int getAdvancePcKey() {
		return advancePcKey;
	}

	public void setAdvancePcKey(int advancePcKey) {
		this.advancePcKey = advancePcKey;
	}

	public int getCurrentRoomCode() {
		return currentRoomCode;
	}

	public void setCurrentRoomCode(int currentRoomCode) {
		this.currentRoomCode = currentRoomCode;
	}

	public int getGrcNumber() {
		return grcNumber;
	}

	public void setGrcNumber(int grcNumber) {
		this.grcNumber = grcNumber;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public int getShiftCode() {
		return shiftCode;
	}

	public void setShiftCode(int shiftCode) {
		this.shiftCode = shiftCode;
	}

	public Date getShiftDate() {
		return shiftDate;
	}

	public void setShiftDate(Date shiftDate) {
		this.shiftDate = shiftDate;
	}

	public int getBillPckey() {
		return billPckey;
	}

	public void setBillPckey(int billPckey) {
		this.billPckey = billPckey;
	}

	public int getCheckInRent() {
		return checkInRent;
	}

	public void setCheckInRent(int checkInRent) {
		this.checkInRent = checkInRent;
	}

	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	public int getDiscountByPercent() {
		return discountByPercent;
	}

	public void setDiscountByPercent(int discountByPercent) {
		this.discountByPercent = discountByPercent;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getDiscountPerDay() {
		return discountPerDay;
	}

	public void setDiscountPerDay(int discountPerDay) {
		this.discountPerDay = discountPerDay;
	}

	public int getDoubleOccRent() {
		return doubleOccRent;
	}

	public void setDoubleOccRent(int doubleOccRent) {
		this.doubleOccRent = doubleOccRent;
	}

	public String getMrMrs() {
		return mrMrs;
	}

	public void setMrMrs(String mrMrs) {
		this.mrMrs = mrMrs;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCorpBooingId() {
		return corpBooingId;
	}

	public void setCorpBooingId(String corpBooingId) {
		this.corpBooingId = corpBooingId;
	}

	public String getCompGstNo() {
		return compGstNo;
	}

	public void setCompGstNo(String compGstNo) {
		this.compGstNo = compGstNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getInstrFo() {
		return instrFo;
	}

	public void setInstrFo(String instrFo) {
		this.instrFo = instrFo;
	}

}