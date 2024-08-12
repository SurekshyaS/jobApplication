package com.surekshya.jobApplication.utils;

import com.surekshya.jobApplication.dto.request.AddressRequest;
import com.surekshya.jobApplication.dto.request.ApplicationRequest;
import com.surekshya.jobApplication.entity.Address;
import com.surekshya.jobApplication.entity.Applicant;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Data
public class ApplicantUtils {

    private static String valueOrBlank(String value) {
        return value == null ? "" : value;
    }

    public static Applicant convertRequestToApplicant(ApplicationRequest request) {

        Applicant newApplicant = new Applicant();
        newApplicant.setFullName(request.getFirstName());
        newApplicant.setLastName(request.getLastName());
        newApplicant.setEmail(request.getEmail());
        newApplicant.setAvailability(request.getAvailability());
        newApplicant.setPhoneNumber(request.getPhoneNumber());
        newApplicant.setEducation(request.getEducation());
        newApplicant.setJobName(request.getJobName());

        Address address = new Address();
        address.setCity(valueOrBlank(request.getAddressRequest().getCity()));
        address.setState(valueOrBlank(request.getAddressRequest().getState()));
        address.setStreet(valueOrBlank(request.getAddressRequest().getStreet()));
        address.setZipCode(valueOrBlank(request.getAddressRequest().getZipCode()));

        newApplicant.setAddress(address);



        return newApplicant;

    }
}
