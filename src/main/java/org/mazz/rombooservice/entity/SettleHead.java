package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;

/**
 * The persistent class for the SettleHead database table.
 * 
 */
@Table(name = "settlehead")
@Entity(name = "SettleHead")
@NamedQuery(name = "SettleHead.findAll", query = "SELECT s FROM SettleHead s")
public class SettleHead implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "settlepckey")
	private int settlePcKey;

	@Column(name = "bankname")
	private String bankName;

	@Column(name = "receiptno")
	private String receiptNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "settledate")
	private java.util.Date settleDate;

	@Column(name = "shiftcode")
	private int shiftCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "shiftdate")
	private java.util.Date shiftDate;

	@Column(name = "tipsamount")
	private String tipsAmount;

	@Column(name = "totalamount")
	private BigDecimal totalAmount;

	@Column(name = "usercode")
	private int userCode;

	public SettleHead() {
	}

	public int getSettlePcKey() {
		return settlePcKey;
	}

	public void setSettlePcKey(int settlePcKey) {
		this.settlePcKey = settlePcKey;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public java.util.Date getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(java.util.Date settleDate) {
		this.settleDate = settleDate;
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

	public String getTipsAmount() {
		return tipsAmount;
	}

	public void setTipsAmount(String tipsAmount) {
		this.tipsAmount = tipsAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

}