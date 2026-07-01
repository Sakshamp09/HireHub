package com.hirehub.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
@Table(name = "companies")
public class Company {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public Integer getFoundedYear() {
		return foundedYear;
	}

	public void setFoundedYear(Integer foundedYear) {
		this.foundedYear = foundedYear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String companyName;

	private String description;

	private String website;

	private String industry;

	private String companySize;

	private Integer foundedYear;

	private String email;

	private String phone;
	
	private String address;

	private String city;

	private String state;

	private String country;
	
	private String logo;

	private Boolean verified;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	@PrePersist
	public void prePersist() {
	    createdAt = LocalDateTime.now();
	    updatedAt = LocalDateTime.now();

	    if (verified == null) {
	        verified = false;
	    }
	}

	@PreUpdate
	public void preUpdate() {
	    updatedAt = LocalDateTime.now();
	}

}