package com.surekshya.jobApplication.dto.request;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data

public class ApplicationRequestDto {

    private String jobName;
    private String firstName;
    //Todo private String middleName
    private String lastName;
    private String email;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressRequestDto addressRequest;
    private String education;
    private String availability;
    private String relocate;
    //Todo private String experienceLevel;
    //Todo private String portfolio;
    //Todo private list<String> skills;


}
