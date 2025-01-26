package com.a14.techinar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.a14.techinar.entity.Event;
import com.a14.techinar.service.EventService;
import com.a14.techinar.utils.ApiResponse;
import com.a14.techinar.utils.IResponse;
import com.a14.techinar.utils.ResponseStatus;

@RestController()
public class HomeController {

	final ResponseStatus MESSAGE = ResponseStatus.SUCCESS;
	private final EventService evService;

	public HomeController(EventService evService) {
		this.evService = evService;
	}

	@GetMapping("/events")
	public ResponseEntity<ApiResponse> home() {
		List<Event> activeEvents = evService.getActiveEvents();
		return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), activeEvents));
	}

	@GetMapping("/events/{id}")
	public ResponseEntity<IResponse> getEventByid(@PathVariable("id") int eventId) {
		try {
			List<Event> event = evService.getEventById(eventId);
			return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), event));
		} catch (Exception e) {

			return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), e.getMessage()));
		}
	}

	@GetMapping("/country")
	public ResponseEntity<ApiResponse> getCountries() {
		try {
			return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), evService.getCountry()));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), e.getMessage()));
		}
	}
}
