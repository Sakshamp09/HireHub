package com.hirehub.dto;

public class RecruiterResponse {

    private Long recruiterId;
    private String message;

    public RecruiterResponse() {
    }

    public RecruiterResponse(Long recruiterId, String message) {
        this.recruiterId = recruiterId;
        this.message = message;
    }

	public Long getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    
}