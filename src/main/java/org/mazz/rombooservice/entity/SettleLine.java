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
@Table(name = "settleline")
@Entity(name = "SettleLine")
@NamedQuery(name = "SettleLine.findAll", query = "SELECT s FROM SettleLine s")
public class SettleLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "linepckey")
	private int linePcKey;

	@Column(name = "settlepckey")
	private int settlePcKey;

	@Column(name = "areacode")
	private int areaCode;

	@Column(name = "settlecode")
	private int settleCode;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "settledetail")
	private String settleDetail;

	public SettleLine() {
	}

	public int getLinePcKey() {
		return linePcKey;
	}

	public void setLinePcKey(int linePcKey) {
		this.linePcKey = linePcKey;
	}

	public int getSettlePcKey() {
		return settlePcKey;
	}

	public void setSettlePcKey(int settlePcKey) {
		this.settlePcKey = settlePcKey;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public int getSettleCode() {
		return settleCode;
	}

	public void setSettleCode(int settleCode) {
		this.settleCode = settleCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getSettleDetail() {
		return settleDetail;
	}

	public void setSettleDetail(String settleDetail) {
		this.settleDetail = settleDetail;
	}

	
	
	

}