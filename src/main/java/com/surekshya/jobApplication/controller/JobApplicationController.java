package com.surekshya.jobApplication.controller;

import com.surekshya.jobApplication.dto.request.ApplicationRequestDto;
import com.surekshya.jobApplication.entity.Applicant;
import com.surekshya.jobApplication.repository.AddressRepository;
import com.surekshya.jobApplication.repository.ApplicantRepository;
import com.surekshya.jobApplication.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JobApplicationController {

    private final ApplicationService service;
    private final ApplicantRepository applicantRepository;
    private final AddressRepository addressRepository;

    @PostMapping("/saveApplicant")
    public Applicant submitApplication(@RequestBody ApplicationRequestDto jobApplicantRequest) {
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

    @GetMapping("/applicantCountMap")
    public Map<String, Long> getApplicantCountMap() {
        return service.getApplicantsCountByStateMap();
    }




}
