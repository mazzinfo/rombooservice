package org.mazz.rombooservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.mazz.rombooservice.custommodal.RoomStatusCustomModal;
import org.mazz.rombooservice.custommodal.RoomTotalStatusCustomModal;
import org.mazz.rombooservice.entity.Guesture;
import org.mazz.rombooservice.repository.GuestureRepository;
import org.mazz.rombooservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@GetMapping("/connectionCheck")
	public List<String> getconnection() {
		List<String> li = new ArrayList<String>();
		li.add("Server is Connected");
		return li;
	}

	@GetMapping("/guestureList")
	public List<Guesture> getGuestures() {
		return guestureRepository.findAll();
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