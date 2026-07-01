package com.hirehub.service;

import com.hirehub.dto.CompanyRequest;
import com.hirehub.dto.CompanyResponse;
import java.util.List;
import com.hirehub.entity.Company;

public interface CompanyService {

    CompanyResponse createCompany(CompanyRequest request);
    
    List<Company> getAllCompanies();
    
    Company getCompanyById(Long id);
    
    CompanyResponse updateCompany(Long id, CompanyRequest request);
    
    CompanyResponse deleteCompany(Long id);

}