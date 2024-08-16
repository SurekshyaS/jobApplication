package com.surekshya.jobApplication.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
public class AddressRequestDto {
    private String street;
    private String city;
    private String state;
    private String zipCode;


}
