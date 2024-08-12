package com.surekshya.jobApplication.service;

import com.surekshya.jobApplication.dto.request.ApplicationRequest;
import com.surekshya.jobApplication.entity.Address;
import com.surekshya.jobApplication.entity.Applicant;
import com.surekshya.jobApplication.repository.AddressRepository;
import com.surekshya.jobApplication.repository.ApplicantRepository;
import com.surekshya.jobApplication.utils.ApplicantUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class JobApplicationService {
    private final AddressRepository addressRepository;
    private final ApplicantRepository applicantRepository;



    public Applicant saveJobApplicant(ApplicationRequest jobApplicationRequest) {
//        ValidateApplicant(jobApplicationRequest);Address address = addressRequestToAddressConverter.convert(jobApplicationRequest.getJobApplicationRequest);
      Applicant applicant = ApplicantUtils.convertRequestToApplicant(jobApplicationRequest);

        log.info("Address saved to database:{}", jobApplicationRequest.getAddressRequest());
        return applicantRepository.save(applicant);
    }


}
