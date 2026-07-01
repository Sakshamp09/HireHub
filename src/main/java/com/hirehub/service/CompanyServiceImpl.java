package com.hirehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirehub.dto.CompanyRequest;
import com.hirehub.dto.CompanyResponse;
import com.hirehub.entity.Company;
import com.hirehub.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyResponse createCompany(CompanyRequest request) {

        Company company = new Company();

        company.setCompanyName(request.getCompanyName());
        company.setDescription(request.getDescription());
        company.setWebsite(request.getWebsite());
        company.setIndustry(request.getIndustry());
        company.setCompanySize(request.getCompanySize());
        company.setFoundedYear(request.getFoundedYear());
        company.setEmail(request.getEmail());
        company.setPhone(request.getPhone());
        company.setAddress(request.getAddress());
        company.setCity(request.getCity());
        company.setState(request.getState());
        company.setCountry(request.getCountry());

        company.setVerified(false);

        Company savedCompany = companyRepository.save(company);

        return new CompanyResponse(
                savedCompany.getId(),
                "Company Created Successfully"
        );
    }
    @Override
    public List<Company> getAllCompanies() {

        return companyRepository.findAll();

    }
    
    @Override
    public Company getCompanyById(Long id) {

        return companyRepository.findById(id).orElse(null);

    }
    
    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest request) {

        Company company = companyRepository.findById(id).orElse(null);

        if (company == null) {
            return new CompanyResponse(null, "Company Not Found");
        }

        company.setCompanyName(request.getCompanyName());
        company.setDescription(request.getDescription());
        company.setWebsite(request.getWebsite());
        company.setIndustry(request.getIndustry());
        company.setCompanySize(request.getCompanySize());
        company.setFoundedYear(request.getFoundedYear());
        company.setEmail(request.getEmail());
        company.setPhone(request.getPhone());
        company.setAddress(request.getAddress());
        company.setCity(request.getCity());
        company.setState(request.getState());
        company.setCountry(request.getCountry());

        companyRepository.save(company);

        return new CompanyResponse(
                company.getId(),
                "Company Updated Successfully"
        );
    }
    
    @Override
    public CompanyResponse deleteCompany(Long id) {

        Company company = companyRepository.findById(id).orElse(null);

        if (company == null) {
            return new CompanyResponse(null, "Company Not Found");
        }

        companyRepository.delete(company);

        return new CompanyResponse(
                id,
                "Company Deleted Successfully"
        );
    }
}