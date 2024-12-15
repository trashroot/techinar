package com.a14.techinar.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.a14.techinar.entity.Event;
import com.a14.techinar.service.EventService;
import com.a14.techinar.utils.ApiResponse;
import com.a14.techinar.utils.IResponse;
import com.a14.techinar.utils.ResponseStatus;

@Controller
public class ManageController {

	final ResponseStatus MESSAGE = ResponseStatus.SUCCESS;
	private final EventService evService;

//	@Value("${imagePath}")
	private String imagePath = "E:\\PHP-waseem\\\\Projects\\img";

	public ManageController(EventService evService) {
		this.evService = evService;
	}

	@GetMapping("/myevents")
	public ResponseEntity<IResponse> getUserEvents() {
		try {
			List<Event> activeEvents = evService.getUserEvents(1);
			return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), activeEvents));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), e.getMessage()));
		}
	}

	@GetMapping("/myevent/{userid}/{id}")
	public ResponseEntity<IResponse> getUserEvents(@PathVariable("userid") int userid, @PathVariable("id") int id) {
		try {
			List<Event> activeEvents = evService.getUserEvent(userid, id);
			return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), activeEvents));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), e.getMessage()));
		}
	}

	@PostMapping("/event")
	public ResponseEntity<IResponse> addEvent(@RequestPart("file") MultipartFile img, Event event) {
		
		try {
			if(!img.isEmpty()) {
				Path imgPath = Paths.get(imagePath);
				Path filePath = imgPath.resolve(img.getOriginalFilename());
				img.transferTo(new File(filePath.toString()));
				event.setImage(filePath.toString());			
			}			
			
		} catch (IOException | IllegalStateException e) {
			return ResponseEntity.ok(new ApiResponse(ResponseStatus.FAIL, e.getMessage()));
		}
		
		Event eve = evService.addEvent(event);
		return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus()));
	}

	@PutMapping("/editEvent")
	public ResponseEntity<IResponse> updateEvent(@RequestPart Event event, @RequestPart MultipartFile img) {

		try {
//			getUserEvent
			evService.getEventById(event.getId());
		} catch (Exception e) {

			return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), e.getMessage()));
		}

		Event eve = evService.updateEvent(event);
		return ResponseEntity.ok(new ApiResponse(MESSAGE, MESSAGE.getStatus(), eve));
	}
}
