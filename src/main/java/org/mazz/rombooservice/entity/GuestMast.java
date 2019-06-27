package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the GuestMast database table.
 * 
 */
@Table(name = "guestmast")
@Entity(name = "GuestMast")
@NamedQuery(name="GuestMast.findAll", query="SELECT g FROM GuestMast g")
public class GuestMast implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "guestid")
	private int guestId;

	@Column(name="address")
	private String address;

	@Column(name="address2")
	private String address2;

	@Column(name="age")
	private String age;

	@Column(name="arrdateinindia")
	private String arrDateInIndia;

	@Column(name="billinstr")
	private String billInstr;

	@Column(name="bookingid")
	private String bookingID;

	@Column(name="city")
	private String city;

	@Column(name="contanctperson")
	private String contanctPerson;

	@Column(name="country")
	private String country;

	@Column(name="countryname")
	private String countryName;

	@Column(name="depdateindia")
	private String depDateIndia;

	@Column(name="discountamount")
	private int discountAmount;

	@Column(name="discountpercentage")
	private int discountPercentage;

	@Column(name="email")
	private String email;

	@Column(name="foreigner")
	private boolean foreigner;

	@Column(name="guestgstno")
	private String guestGstNo;

	@Column(name="guestname")
	private String guestName;

	@Column(name="idproof")
	private String idProof;

	@Column(name="instrbev")
	private String instrBev;

	@Column(name="instrfo")
	private String instrFO;

	@Column(name="instrhk")
	private String instrHk;

	@Column(name="issuedate")
	private String issueDate;

	@Column(name="mobileno")
	private String mobileNo;

	@Column(name="mrmrs")
	private String mrMrs;

	@Column(name="otherdetail")
	private String otherDetail;

	@Column(name="otherinstr")
	private String otherInstr;

	@Column(name="passportno")
	private String passportNo;

	@Column(name="phone")
	private String phone;

	@Column(name="pincode")
	private String pincode;

	@Column(name="placeofissue")
	private String placeOfIssue;

	@Column(name="planname")
	private String planName;

	@Column(name="state")
	private String state;

	@Column(name="transactiondate")
	private Time transactionDate;

	@Column(name="transactionid")
	private String transactionId;

	@Column(name="validdate")
	private String validDate;

	@Column(name="visaissuedate")
	private String visaIssueDate;

	@Column(name="visano")
	private String visaNo;

	@Column(name="visavaliddate")
	private String visaValidDate;

	//bi-directional many-to-one association to DebtorMast
	@ManyToOne
	@JoinColumn(name="grpcode")
	private DebtorMast debtorMast;

	public GuestMast() {
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getArrDateInIndia() {
		return arrDateInIndia;
	}

	public void setArrDateInIndia(String arrDateInIndia) {
		this.arrDateInIndia = arrDateInIndia;
	}

	public String getBillInstr() {
		return billInstr;
	}

	public void setBillInstr(String billInstr) {
		this.billInstr = billInstr;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getDepDateIndia() {
		return depDateIndia;
	}

	public void setDepDateIndia(String depDateIndia) {
		this.depDateIndia = depDateIndia;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isForeigner() {
		return foreigner;
	}

	public void setForeigner(boolean foreigner) {
		this.foreigner = foreigner;
	}

	public String getGuestGstNo() {
		return guestGstNo;
	}

	public void setGuestGstNo(String guestGstNo) {
		this.guestGstNo = guestGstNo;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getInstrBev() {
		return instrBev;
	}

	public void setInstrBev(String instrBev) {
		this.instrBev = instrBev;
	}

	public String getInstrFO() {
		return instrFO;
	}

	public void setInstrFO(String instrFO) {
		this.instrFO = instrFO;
	}

	public String getInstrHk() {
		return instrHk;
	}

	public void setInstrHk(String instrHk) {
		this.instrHk = instrHk;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMrMrs() {
		return mrMrs;
	}

	public void setMrMrs(String mrMrs) {
		this.mrMrs = mrMrs;
	}

	public String getOtherDetail() {
		return otherDetail;
	}

	public void setOtherDetail(String otherDetail) {
		this.otherDetail = otherDetail;
	}

	public String getOtherInstr() {
		return otherInstr;
	}

	public void setOtherInstr(String otherInstr) {
		this.otherInstr = otherInstr;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPlaceOfIssue() {
		return placeOfIssue;
	}

	public void setPlaceOfIssue(String placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Time getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Time transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getVisaIssueDate() {
		return visaIssueDate;
	}

	public void setVisaIssueDate(String visaIssueDate) {
		this.visaIssueDate = visaIssueDate;
	}

	public String getVisaNo() {
		return visaNo;
	}

	public void setVisaNo(String visaNo) {
		this.visaNo = visaNo;
	}

	public String getVisaValidDate() {
		return visaValidDate;
	}

	public void setVisaValidDate(String visaValidDate) {
		this.visaValidDate = visaValidDate;
	}

	public DebtorMast getDebtorMast() {
		return debtorMast;
	}

	public void setDebtorMast(DebtorMast debtorMast) {
		this.debtorMast = debtorMast;
	}

	
}