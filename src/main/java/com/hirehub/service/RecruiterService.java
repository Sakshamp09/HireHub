package com.hirehub.service;

import java.util.List;

import com.hirehub.dto.RecruiterRequest;
import com.hirehub.dto.RecruiterResponse;
import com.hirehub.entity.Recruiter;

public interface RecruiterService {

    RecruiterResponse createRecruiter(RecruiterRequest request);

    List<Recruiter> getAllRecruiters();

    Recruiter getRecruiterById(Long id);

    RecruiterResponse updateRecruiter(Long id, RecruiterRequest request);

    RecruiterResponse deleteRecruiter(Long id);
}