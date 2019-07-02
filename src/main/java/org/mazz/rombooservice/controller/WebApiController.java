package org.mazz.rombooservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mazz.rombooservice.custommodal.RoomStatusCustomModal;
import org.mazz.rombooservice.custommodal.RoomTotalStatusCustomModal;
import org.mazz.rombooservice.custommodal.TodayBookingCustomModal;
import org.mazz.rombooservice.entity.ArrivalMast;
import org.mazz.rombooservice.entity.DebtorMast;
import org.mazz.rombooservice.entity.GuestMast;
import org.mazz.rombooservice.entity.Guesture;
import org.mazz.rombooservice.entity.RoomType;
import org.mazz.rombooservice.entity.SettleMast;
import org.mazz.rombooservice.repository.ArrivalMastRepository;
import org.mazz.rombooservice.repository.DebtorMastRepository;
import org.mazz.rombooservice.repository.GuestMastRepository;
import org.mazz.rombooservice.repository.GuestureRepository;
import org.mazz.rombooservice.repository.RoomTypeRepository;
import org.mazz.rombooservice.repository.SettleMastRepository;
import org.mazz.rombooservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private SettleMastRepository SettleMastRepository;
	
	
	@GetMapping("/connectionCheck")
	public List<String> getconnection() {
		List<String> li = new ArrayList<String>();
		li.add("Server is Connected");
		return li;
	}
	@GetMapping("/checkGuest/{guestName}")
	public Optional<List<GuestMast>> userValidation(@PathVariable("guestName") String guestName) throws org.mazz.rombooservice.exception.ResourceNotFoundException {

		Optional<List<GuestMast>> guestList = guestMastRepository.getGuestList(guestName);
		return guestList;
	}
	

	@GetMapping("/guestureList")
	public List<Guesture> getGuestures() {
		return guestureRepository.findAll();
	}
	
	@GetMapping("/settleList")
	public List<SettleMast> getSettleList() {
		return SettleMastRepository.findAll();
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
	
	
	
	@GetMapping("/roomCurrentStatus")
	public List<RoomStatusCustomModal> getCurrentRoomStatus() {
		return roomService.getCurrentRoomStatus();
	}
	
	
	
	@GetMapping("/totalRoomStatus")
	public RoomTotalStatusCustomModal totalRoomStatus() {
		return roomService.getTotalRoomStatus();
	}
	
}