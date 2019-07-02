package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SettleMast database table.
 * 
 */
@Table(name = "settlemast")
@Entity(name = "SettleMast")
@NamedQuery(name="SettleMast.findAll", query="SELECT s FROM SettleMast s")
public class SettleMast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "settlecode")
	private int settleCode;

	@Column(name="amount1")
	private BigDecimal amount1;

	@Column(name="facode")
	private long faCode;

	@Column(name="settlename")
	private String settleName;

	@Column(name="sysgen")
	private String sysGen;

	public SettleMast() {
	}

	public int getSettleCode() {
		return settleCode;
	}

	public void setSettleCode(int settleCode) {
		this.settleCode = settleCode;
	}

	public BigDecimal getAmount1() {
		return amount1;
	}

	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}

	public long getFaCode() {
		return faCode;
	}

	public void setFaCode(long faCode) {
		this.faCode = faCode;
	}

	public String getSettleName() {
		return settleName;
	}

	public void setSettleName(String settleName) {
		this.settleName = settleName;
	}

	public String getSysGen() {
		return sysGen;
	}

	public void setSysGen(String sysGen) {
		this.sysGen = sysGen;
	}

	
}