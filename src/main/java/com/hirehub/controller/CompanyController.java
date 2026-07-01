package com.hirehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hirehub.dto.CompanyRequest;
import com.hirehub.dto.CompanyResponse;
import com.hirehub.service.CompanyService;
import java.util.List;
import com.hirehub.entity.Company;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public CompanyResponse createCompany(@RequestBody CompanyRequest request) {

        return companyService.createCompany(request);

    }
    
    @GetMapping
    public List<Company> getAllCompanies() {

        return companyService.getAllCompanies();

    }
    
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {

        return companyService.getCompanyById(id);

    }
    
    @PutMapping("/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id,
                                         @RequestBody CompanyRequest request) {

        return companyService.updateCompany(id, request);

    }
    
    @DeleteMapping("/{id}")
    public CompanyResponse deleteCompany(@PathVariable Long id) {

        return companyService.deleteCompany(id);

    }

}