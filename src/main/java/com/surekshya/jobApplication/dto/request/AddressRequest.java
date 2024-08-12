package com.surekshya.jobApplication.dto.request;

import lombok.*;

@Data
@Builder


public class AddressRequest {
    private String street;
    private String city;
    private String state;
    private String zipCode;


}
