package com.coffee.miniproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressRequestDto {
    private Long postcode;
    private String address;
    private String simpleAddress;
    private String latitude;
    private String longitude;
}
