package com.hirehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hirehub.dto.RecruiterRequest;
import com.hirehub.dto.RecruiterResponse;
import com.hirehub.entity.Recruiter;
import com.hirehub.service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping
    public RecruiterResponse createRecruiter(@RequestBody RecruiterRequest request) {
        return recruiterService.createRecruiter(request);
    }

    @GetMapping
    public List<Recruiter> getAllRecruiters() {
        return recruiterService.getAllRecruiters();
    }

    @GetMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable Long id) {
        return recruiterService.getRecruiterById(id);
    }

    @PutMapping("/{id}")
    public RecruiterResponse updateRecruiter(@PathVariable Long id,
                                             @RequestBody RecruiterRequest request) {
        return recruiterService.updateRecruiter(id, request);
    }

    @DeleteMapping("/{id}")
    public RecruiterResponse deleteRecruiter(@PathVariable Long id) {
        return recruiterService.deleteRecruiter(id);
    }
}