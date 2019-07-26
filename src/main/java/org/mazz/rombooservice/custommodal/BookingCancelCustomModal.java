package org.mazz.rombooservice.custommodal;

import java.util.List;

import org.mazz.rombooservice.entity.SettleMast;



public class BookingCancelCustomModal {
	private String  reason;
	private int bookingPcKey;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getBookingPcKey() {
		return bookingPcKey;
	}
	public void setBookingPcKey(int bookingPcKey) {
		this.bookingPcKey = bookingPcKey;
	}
	@Override
	public String toString() {
		return "BookingCancelCustomModal [reason=" + reason + ", bookingPcKey=" + bookingPcKey + "]";
	}
	

	
	
	
}
