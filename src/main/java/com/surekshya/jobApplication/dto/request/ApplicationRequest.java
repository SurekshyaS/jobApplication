package com.surekshya.jobApplication.dto.request;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;


@Data

public class ApplicationRequest {

    private String jobName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressRequest addressRequest;
    private String education;
    private String availability;
    private String relocate;


}
