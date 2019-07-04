package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the BookingLine database table.
 * 
 */
@Table(name = "bookingline")
@Entity(name = "BookingLine")
@NamedQuery(name="BookingLine.findAll", query="SELECT b FROM BookingLine b")
public class BookingLine implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="linepckey")
	private int linePcKey;

	@Column(name="billinstr")
	private String billInstr;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fromdate")
	private java.util.Date fromDate;


	@Column(name="noofrooms")
	private int noOfRooms;

	@Column(name="noofroomsblocked")
	private int noOfRoomsBlocked;

	@Column(name="pax")
	private int pax;

	@Column(name="pickupdetails")
	private String picKupDetails;

	@Column(name="roomsbooked")
	private int roomsBooked;

	@Column(name="roomtype")
	private String roomType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="todate")
	private  java.util.Date toDate;


	@Column(name="bookingpckey")
	private int bookingPcKey;

	public BookingLine() {
	}

	public int getLinePcKey() {
		return linePcKey;
	}

	public void setLinePcKey(int linePcKey) {
		this.linePcKey = linePcKey;
	}

	public String getBillInstr() {
		return billInstr;
	}

	public void setBillInstr(String billInstr) {
		this.billInstr = billInstr;
	}

	public java.util.Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public int getNoOfRoomsBlocked() {
		return noOfRoomsBlocked;
	}

	public void setNoOfRoomsBlocked(int noOfRoomsBlocked) {
		this.noOfRoomsBlocked = noOfRoomsBlocked;
	}

	public int getPax() {
		return pax;
	}

	public void setPax(int pax) {
		this.pax = pax;
	}

	public String getPicKupDetails() {
		return picKupDetails;
	}

	public void setPicKupDetails(String picKupDetails) {
		this.picKupDetails = picKupDetails;
	}

	public int getRoomsBooked() {
		return roomsBooked;
	}

	public void setRoomsBooked(int roomsBooked) {
		this.roomsBooked = roomsBooked;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public java.util.Date getToDate() {
		return toDate;
	}

	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
	}

	public int getBookingPcKey() {
		return bookingPcKey;
	}

	public void setBookingPcKey(int bookingPcKey) {
		this.bookingPcKey = bookingPcKey;
	}

	
	
}