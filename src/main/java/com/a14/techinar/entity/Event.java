package com.a14.techinar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity()
public class Event {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;

	@Column(columnDefinition = "TEXT")
	private String description;

	private String image;

	private String occursOn;

	private String startAt;

	private String endAt;

	private String venue;

	private String city;

	private String country;

	private String organizer;

	private Boolean inviteOnly;
	
	private Integer createdBy;
	
	private Integer published;
	
	private Integer approved;
	
	private Integer approvedBy;
	
	private Integer isDeleted;
	
	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Event() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOccursOn() {
		return occursOn;
	}

	public void setOccursOn(String occursOn) {
		this.occursOn = occursOn;
	}

	public String getStartAt() {
		return startAt;
	}

	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}

	public String getEndAt() {
		return endAt;
	}

	public void setEndAt(String endAt) {
		this.endAt = endAt;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public Boolean getInviteOnly() {
		return inviteOnly;
	}

	public void setInviteOnly(Boolean inviteOnly) {
		this.inviteOnly = inviteOnly;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getPublished() {
		return published;
	}

	public void setPublished(Integer published) {
		this.published = published;
	}

	public Integer getApproved() {
		return approved;
	}

	public void setApproved(Integer approved) {
		this.approved = approved;
	}

	public Integer getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", occursOn=" + occursOn + ", startAt=" + startAt + ", endAt=" + endAt + ", venue=" + venue
				+ ", city=" + city + ", country=" + country + ", organizer=" + organizer + ", inviteOnly=" + inviteOnly
				+ ", createdBy=" + createdBy + ", published=" + published + ", approved=" + approved + ", approvedBy="
				+ approvedBy + "]";
	}
	
	
}
