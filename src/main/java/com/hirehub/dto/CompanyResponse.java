package com.hirehub.dto;

public class CompanyResponse {

    private Long companyId;
    private String message;

    public CompanyResponse() {
    }

    public CompanyResponse(Long companyId, String message) {
        this.companyId = companyId;
        this.message = message;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}