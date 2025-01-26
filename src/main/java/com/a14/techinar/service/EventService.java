package com.a14.techinar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.a14.techinar.entity.Event;
import com.a14.techinar.exception.ResourceNotFound;
import com.a14.techinar.repository.EventRepository;

import jakarta.transaction.Transactional;

@Service()
public class EventService {

	private final EventRepository evRepo;
	LocalDate currentDate = LocalDate.now();

	public EventService(EventRepository evRepo) {
		this.evRepo = evRepo;
	}

	public List<Event> getAllEvents() {
		List<Event> all = evRepo.findAll();
		return all;
	}

	public List<Event> getActiveEvents() {
		List<Event> all = evRepo
				.findByOccursOnGreaterThanAndPublishedAndApprovedOrderByOccursOnDesc(currentDate.toString(), 1, 1);
		return all;
	}

	public List<Event> getEventById(int id) {
		Event ev = evRepo.findById(id).orElseThrow(() -> new ResourceNotFound("No event found."));
		
		List<Event> allEvent = new ArrayList<>();
		allEvent.add(ev);
		return allEvent;
	}

	public List<Event> getUserEvents(int id) {

		List<Event> userEvents = evRepo.findByCreatedByOrderByIdDesc(id).stream().toList();
		if (userEvents.isEmpty()) {
			throw new ResourceNotFound("No event found.");
		}
		return userEvents;
	}
	
	public List<Event> getUserEvent(int userId, int id) {

		List<Event> userEvents = evRepo.findByCreatedByAndId(userId, id).stream().toList();
		if (userEvents.isEmpty()) {
			throw new ResourceNotFound("No event found.");
		}
		return userEvents;
	}

	public Event addEvent(Event event) {
		return evRepo.save(event);
	}

	@Transactional
	public Event updateEvent(Event event) {
		return evRepo.save(event);
	}
	
	public void deleteEvent(int id) {
		Event e = evRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Event not found."));
		System.out.println(e);
		evRepo.deleteEvent(id);
	}
	
	public List<String> getCountry(){
		List<String> countries = evRepo.findDistinctCountry();
		if (countries.isEmpty()) {
			throw new ResourceNotFound("No event found.");
		}
		
		return countries;
	}
}
