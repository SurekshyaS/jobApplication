package com.surekshya.jobApplication.controller;

import com.surekshya.jobApplication.dto.request.ApplicationRequest;
import com.surekshya.jobApplication.entity.Applicant;
import com.surekshya.jobApplication.service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService service;

    @PostMapping("/saveApplicant")
    public Applicant submitApplication(@RequestBody ApplicationRequest jobApplicantRequest) {
        return service.saveJobApplicant(jobApplicantRequest);
    }
}
