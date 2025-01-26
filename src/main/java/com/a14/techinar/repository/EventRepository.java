package com.a14.techinar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.a14.techinar.entity.Event;

@Repository()
public interface EventRepository extends JpaRepository<Event, Integer> {
	
	List<Event> findByCreatedByOrderByIdDesc(int id);

	List<Event> findByCreatedByAndId(int userid, int id);

	List<Event> findByOccursOnGreaterThanAndPublishedAndApprovedOrderByOccursOnDesc(String startDate, int published,
			int approved);
	
	@Query(value="UPDATE Event SET isDeleted=1 WHERE id= ?1", nativeQuery = true)
	void deleteEvent(int id);
	
	@Query(value = "SELECT DISTINCT country from event WHERE country IS NOT null", nativeQuery = true)
	List<String> findDistinctCountry();
}
