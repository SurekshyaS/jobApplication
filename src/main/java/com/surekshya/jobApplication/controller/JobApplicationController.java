package com.surekshya.jobApplication.controller;

import com.surekshya.jobApplication.dto.request.ApplicationRequest;
import com.surekshya.jobApplication.entity.Applicant;
import com.surekshya.jobApplication.repository.ApplicantRepository;
import com.surekshya.jobApplication.service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService service;
    private final ApplicantRepository applicantRepository;

    @PostMapping("/saveApplicant")
    public Applicant submitApplication(@RequestBody ApplicationRequest jobApplicantRequest) {
        return service.saveJobApplicant(jobApplicantRequest);
    }

    @GetMapping("/allApplicant")
    public List<Applicant> getApplicants() {
      return (List<Applicant>) applicantRepository.findAll();

    }

    @GetMapping("/applicantByState")
    public List<Applicant> getApplicantsByState(@RequestParam String state) {
        return service.getApplicantByState(state);

    }


}
