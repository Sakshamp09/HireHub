package com.hirehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirehub.dto.RecruiterRequest;
import com.hirehub.dto.RecruiterResponse;
import com.hirehub.entity.Company;
import com.hirehub.entity.Recruiter;
import com.hirehub.entity.User;
import com.hirehub.repository.CompanyRepository;
import com.hirehub.repository.RecruiterRepository;
import com.hirehub.repository.UserRepository;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public RecruiterResponse createRecruiter(RecruiterRequest request) {

        User user = userRepository.findById(request.getUserId()).orElse(null);

        Company company = companyRepository.findById(request.getCompanyId()).orElse(null);

        if (user == null || company == null) {
            return new RecruiterResponse(null, "User or Company Not Found");
        }

        Recruiter recruiter = new Recruiter();

        recruiter.setDesignation(request.getDesignation());
        recruiter.setExperience(request.getExperience());
        recruiter.setLinkedinUrl(request.getLinkedinUrl());
        recruiter.setProfileImage(request.getProfileImage());

        recruiter.setUser(user);
        recruiter.setCompany(company);

        Recruiter savedRecruiter = recruiterRepository.save(recruiter);

        return new RecruiterResponse(
                savedRecruiter.getId(),
                "Recruiter Created Successfully"
        );
    }
    
    @Override
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    @Override
    public Recruiter getRecruiterById(Long id) {
        return recruiterRepository.findById(id).orElse(null);
    }

    @Override
    public RecruiterResponse updateRecruiter(Long id, RecruiterRequest request) {

        Recruiter recruiter = recruiterRepository.findById(id).orElse(null);

        if (recruiter == null) {
            return new RecruiterResponse(null, "Recruiter Not Found");
        }

        Company company = companyRepository.findById(request.getCompanyId()).orElse(null);
        User user = userRepository.findById(request.getUserId()).orElse(null);

        if (company == null || user == null) {
            return new RecruiterResponse(null, "User or Company Not Found");
        }

        recruiter.setDesignation(request.getDesignation());
        recruiter.setExperience(request.getExperience());
        recruiter.setLinkedinUrl(request.getLinkedinUrl());
        recruiter.setProfileImage(request.getProfileImage());
        recruiter.setUser(user);
        recruiter.setCompany(company);

        recruiterRepository.save(recruiter);

        return new RecruiterResponse(
                recruiter.getId(),
                "Recruiter Updated Successfully"
        );
    }

    @Override
    public RecruiterResponse deleteRecruiter(Long id) {

        Recruiter recruiter = recruiterRepository.findById(id).orElse(null);

        if (recruiter == null) {
            return new RecruiterResponse(null, "Recruiter Not Found");
        }

        recruiterRepository.delete(recruiter);

        return new RecruiterResponse(
                id,
                "Recruiter Deleted Successfully"
        );
    }
}