package org.mazz.rombooservice.entity;


import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the DebtorMast database table.
 * 
 */
@Table(name = "debtormast")
@Entity(name = "DebtorMast")
@NamedQuery(name="DebtorMast.findAll", query="SELECT d FROM DebtorMast d")
public class DebtorMast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "debtorcode")
	private int debtorCode;

	@Column(name="address")
	private String address;

	@Column(name="agentcom")
	private String agentCom;

	@Column(name="city")
	private String city;

	@Column(name="contanctperson")
	private String contanctPerson;

	@Column(name="country")
	private String country;

	@Column(name="debtorname")
	private String debtorName;

	@Column(name="discountamount")
	private int discountAmount;

	@Column(name="discountpercentage")
	private int discountPercentage;

	@Column(name="emailid")
	private String emailId;	

	@Column(name="phoneno")
	private String phoneNo;

	@Column(name="pincode")
	private String pincode;

	
	public DebtorMast() {
	}


	public int getDebtorCode() {
		return debtorCode;
	}


	public void setDebtorCode(int debtorCode) {
		this.debtorCode = debtorCode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAgentCom() {
		return agentCom;
	}


	public void setAgentCom(String agentCom) {
		this.agentCom = agentCom;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getContanctPerson() {
		return contanctPerson;
	}


	public void setContanctPerson(String contanctPerson) {
		this.contanctPerson = contanctPerson;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getDebtorName() {
		return debtorName;
	}


	public void setDebtorName(String debtorName) {
		this.debtorName = debtorName;
	}


	public int getDiscountAmount() {
		return discountAmount;
	}


	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}


	public int getDiscountPercentage() {
		return discountPercentage;
	}


	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


}