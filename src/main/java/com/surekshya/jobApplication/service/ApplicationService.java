package com.surekshya.jobApplication.service;

import com.surekshya.jobApplication.dto.request.ApplicationRequestDto;
import com.surekshya.jobApplication.dto.response.ApplicantCountDto;
import com.surekshya.jobApplication.entity.Applicant;
import com.surekshya.jobApplication.repository.AddressRepository;
import com.surekshya.jobApplication.repository.ApplicantCountProjection;
import com.surekshya.jobApplication.repository.ApplicantRepository;
import com.surekshya.jobApplication.utils.ApplicantUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationService {
    private final AddressRepository addressRepository;
    private final ApplicantRepository applicantRepository;

    public Applicant saveJobApplicant(ApplicationRequestDto jobApplicationRequest) {
//        ValidateApplicant(jobApplicationRequest);Address address = addressRequestToAddressConverter.convert(jobApplicationRequest.getJobApplicationRequest);
      Applicant applicant = ApplicantUtils.convertRequestToApplicant(jobApplicationRequest);

        log.info("Address saved to database:{}", jobApplicationRequest.getAddressRequest());
        return applicantRepository.save(applicant);
    }

    public List<Applicant> getApplicantByState(String state) {
        return applicantRepository.findApplicantsByState(state);
    }

    public List<Applicant> findAllApplicant() {
        return (List<Applicant>) applicantRepository.findAll();
    }

    public Map<String, Long> getApplicantsCountByStateMap() {
        List<ApplicantCountProjection> applicantsCount = addressRepository.findApplicantCountByState();

        // Log or print the applicantsCount list
        applicantsCount.forEach(projection ->
                System.out.println("State: " + projection.getState() + ", Count: " + projection.getApplicantCount())
        );
        return applicantsCount.stream()
                //TODO coming in applicant coming in as null
                .filter(projection -> projection.getState() != null && projection.getApplicantCount() != null)
                .collect(Collectors.toMap(
                        ApplicantCountProjection::getState,
                        ApplicantCountProjection::getApplicantCount
                ));
    }

}
