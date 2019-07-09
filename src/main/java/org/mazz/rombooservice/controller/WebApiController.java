package org.mazz.rombooservice.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mazz.rombooservice.custommodal.BookingCustomModal;
import org.mazz.rombooservice.custommodal.RoomStatusCustomModal;
import org.mazz.rombooservice.custommodal.RoomTotalStatusCustomModal;
import org.mazz.rombooservice.custommodal.TodayBookingCustomModal;
import org.mazz.rombooservice.entity.Advance;
import org.mazz.rombooservice.entity.ArrivalMast;
import org.mazz.rombooservice.entity.BookingHead;
import org.mazz.rombooservice.entity.BookingLine;
import org.mazz.rombooservice.entity.DebtorMast;
import org.mazz.rombooservice.entity.GuestMast;
import org.mazz.rombooservice.entity.Guesture;
import org.mazz.rombooservice.entity.RoomType;
import org.mazz.rombooservice.entity.SettleHead;
import org.mazz.rombooservice.entity.SettleLine;
import org.mazz.rombooservice.entity.SettleMast;
import org.mazz.rombooservice.repository.AdvanceRepository;
import org.mazz.rombooservice.repository.ArrivalMastRepository;
import org.mazz.rombooservice.repository.BookingHeadRepository;
import org.mazz.rombooservice.repository.BookingLineRepository;
import org.mazz.rombooservice.repository.DebtorMastRepository;
import org.mazz.rombooservice.repository.GuestMastRepository;
import org.mazz.rombooservice.repository.GuestureRepository;
import org.mazz.rombooservice.repository.RoomTypeRepository;
import org.mazz.rombooservice.repository.SettleHeadRepository;
import org.mazz.rombooservice.repository.SettleLineRepository;
import org.mazz.rombooservice.repository.SettleMastRepository;
import org.mazz.rombooservice.service.RoomService;
import org.mazz.rombooservice.utill.DateUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roomapi")
@CrossOrigin
public class WebApiController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private GuestureRepository guestureRepository;

	@Autowired
	private ArrivalMastRepository arrivalMastRepository;

	@Autowired
	private RoomTypeRepository roomTypeRepository;

	@Autowired
	private DebtorMastRepository debtorMastRepository;

	@Autowired
	private GuestMastRepository guestMastRepository;

	@Autowired
	private SettleMastRepository settleMastRepository;

	@Autowired
	private BookingHeadRepository bookingHeadRepository;

	@Autowired
	private BookingLineRepository bookingLineRepository;

	@Autowired
	private AdvanceRepository advanceRepository;

	@Autowired
	private SettleHeadRepository settleHeadRepository;

	@Autowired
	private SettleLineRepository settleLineRepository;

	@GetMapping("/connectionCheck")
	public List<String> getconnection() {
		List<String> li = new ArrayList<String>();
		li.add("Server is Connected");
		return li;
	}

	@GetMapping("/checkGuest/{guestName}")
	public Optional<List<GuestMast>> userValidation(@PathVariable("guestName") String guestName)
			throws org.mazz.rombooservice.exception.ResourceNotFoundException {

		Optional<List<GuestMast>> guestList = guestMastRepository.getGuestList(guestName);
		return guestList;
	}

	

	
	
	
	
	@PostMapping("/saveReservation")
	public void saveReservation(@RequestBody BookingCustomModal bcm) {
		
		System.out.println("bcm.." + bcm.toString());
		
		
		int guestId;
		if(bcm.getGuestId()=="" && bcm.getGuestId()==null) {
		GuestMast gm = new GuestMast();
		Optional<Guesture> gs = guestureRepository.findById(Integer.valueOf(bcm.getGuesture()));
		gm.setMrMrs(gs.get().getDescription());
		gm.setGuestName(bcm.getGuestName());
		gm.setCity(bcm.getCity());
		gm.setPhone(bcm.getPhoneNo());
		gm.setGrpCode(Integer.parseInt(bcm.getCompanyName()));
		gm.setEmail(bcm.getEmailId());
		gm.setBillInstr(bcm.getInstructionsFor());
		gm.setBookingID(bcm.getBookingId());
		gm.setTransactionDate(new java.util.Date());
		GuestMast gms = guestMastRepository.save(gm);
		guestId=gms.getGuestId();
		
		}else {
			guestId=Integer.parseInt(bcm.getGuestId());
		}
		
		Optional<RoomType> rt = roomTypeRepository.findById(Integer.valueOf(bcm.getRoomType()));

		BookingHead bh = new BookingHead();
		bh.setGuestId(guestId);
		bh.setAgentCode(0);
		bh.setArrivalMode(Integer.parseInt(bcm.getBookingStatus()));
		bh.setBookingDate(new java.util.Date());
		bh.setBookingShiftCode(14);
		bh.setBookingMode(Integer.parseInt(bcm.getCompanyName()));
		bh.setActive("Y");
		bh.setBlocked("N");
		bh.setShiftDate(new java.util.Date());
		bh.setShiftCode(14);
		bh.setCompGust("Gust");
		BookingHead bhs = bookingHeadRepository.save(bh);

		BookingLine bl = new BookingLine();
		bl.setBookingPcKey(bhs.getBookingPcKey());
		bl.setRoomType(rt.get().getTypeName());
		bl.setNoOfRooms(Integer.parseInt(bcm.getNoOfRooms()));
		bl.setFromDate(DateUtill.getDateTime(bcm.getBookingFromDate(), bcm.getBookingFromTime()));
		bl.setToDate(DateUtill.getDateTime(bcm.getBookingToDate(), bcm.getBookingToTime()));
		bl.setRoomsBooked(Integer.parseInt(bcm.getNoOfRooms()));
		bl.setPax(Integer.parseInt(bcm.getPax()));
		bl.setBillInstr(bcm.getInstructionsFor());
		bl.setPicKupDetails(bcm.getPickupDetails());
		BookingLine bls = bookingLineRepository.save(bl);

		if (bcm.getAdvance() != "" && !bcm.getAdvance().equals("0")) {

			SettleHead sh = new SettleHead();
			sh.setSettleDate(new java.util.Date());
			sh.setUserCode(72);
			sh.setShiftCode(14);
			sh.setShiftDate(new java.util.Date());
			sh.setTotalAmount(new BigDecimal(bcm.getAdvance()));

			SettleHead shs = settleHeadRepository.save(sh);

			int receiptNo = 0;

			List<Advance> adl = advanceRepository.findAll();
			System.out.println("adl.." + adl.size());

			receiptNo = Integer.parseInt(adl.get(adl.size() - 1).getReceiptNo()) + 1;

			System.out.println("receiptNo.." + receiptNo + "cc" + adl.size());

			Advance ad = new Advance();
			ad.setBookingPcKey("" + bhs.getBookingPcKey());
			ad.setDtTime(new java.util.Date());
			ad.setAmount(new BigDecimal(bcm.getAdvance()));
			ad.setReceiptNo("" + receiptNo);
			ad.setSettlePckey("" + shs.getSettlePcKey());
			ad.setAdvTransDate(new java.util.Date());
			advanceRepository.save(ad);

			for (SettleMast sm : bcm.getSettleList()) {
				if (sm.getAmount1() != null && sm.getAmount1().compareTo(BigDecimal.ZERO) > 0) {
					SettleLine sl = new SettleLine();
					sl.setSettlePcKey(shs.getSettlePcKey());
					sl.setAreaCode(2);
					sl.setSettleCode(sm.getSettleCode());
					sl.setAmount(sm.getAmount1());
					settleLineRepository.save(sl);
				}
			}
		}

		

	}

	@GetMapping("/guestureList")
	public List<Guesture> getGuestures() {
		return guestureRepository.findAll();
	}
	
	@GetMapping("/checkGuesture/{guestureName}")
	public Optional<List<Guesture>> getGuester(@PathVariable("guestureName") String guestureName)
			throws org.mazz.rombooservice.exception.ResourceNotFoundException {

		Optional<List<Guesture>> guestList = guestureRepository.getGuestereByDesc(guestureName);
		return guestList;
	}
	
	
	@GetMapping("/bookingList/{guestId}")
	public List<TodayBookingCustomModal> getBookingListByGuestId(@PathVariable("guestId") int guestId) {
		return roomService.getBookingListByGustId(guestId);
	}
	
	@GetMapping("/guestList")
	public List<GuestMast> getGuestList() {
		return guestMastRepository.findAll();
	}

	@GetMapping("/settleList")
	public List<SettleMast> getSettleList() {
		return settleMastRepository.findAll();
	}

	@GetMapping("/bookingStatusList")
	public List<ArrivalMast> getBookingStatusList() {
		return arrivalMastRepository.findAll();
	}

	@GetMapping("/roomTypeList")
	public List<RoomType> getRoomTypeList() {
		return roomTypeRepository.findAll();
	}

	@GetMapping("/companyList")
	public List<DebtorMast> getCompanyList() {
		return debtorMastRepository.findAll();
	}

	@GetMapping("/todayBookingList")
	public List<TodayBookingCustomModal> getTodayBookingList() {
		return roomService.getTodayBookingList();
	}
	@GetMapping("/bookingList")
	public List<TodayBookingCustomModal> getBookingList() {
		return roomService.getBookingList();
	}
	
	

	@GetMapping("/roomCurrentStatus")
	public List<RoomStatusCustomModal> getCurrentRoomStatus() {
		return roomService.getCurrentRoomStatus();
	}

	@GetMapping("/totalRoomStatus")
	public RoomTotalStatusCustomModal totalRoomStatus() {
		return roomService.getTotalRoomStatus();
	}

}