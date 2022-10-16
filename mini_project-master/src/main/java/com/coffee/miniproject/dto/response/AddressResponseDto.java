package com.coffee.miniproject.dto.response;

import com.coffee.miniproject.model.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressResponseDto {

    private Long id;
    private Long postcode;
    private String address;
    private String simpleAddress;
    private String latitude;
    private String longitude;

    public AddressResponseDto(Address address) {
        this.id = address.getId();
        this.postcode = address.getPostcode();
        this.address = address.getAddress();
        this.simpleAddress = address.getSimpleAddress();
        this.latitude = address.getLatitude();
        this.longitude = address.getLongitude();
    }
}
