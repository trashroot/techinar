package com.a14.techinar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.a14.techinar.entity.Event;

@Repository()
public interface EventRepository extends JpaRepository<Event, Integer> {
	
	List<Event> findByCreatedByOrderByIdDesc(int id);

	List<Event> findByCreatedByAndId(int userid, int id);

	List<Event> findByOccursOnGreaterThanAndPublishedAndApprovedOrderByOccursOnDesc(String startDate, int published,
			int approved);
}
