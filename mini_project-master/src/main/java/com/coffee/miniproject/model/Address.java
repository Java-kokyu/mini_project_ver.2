package com.coffee.miniproject.model;

import com.coffee.miniproject.dto.request.AddressRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private Long postcode;
    @Column
    private String address;
    @Column
    private String simpleAddress;
    @Column
    private String latitude;
    @Column
    private String longitude;

    public Address(AddressRequestDto requestDto) {
        this.postcode = requestDto.getPostcode();
        this.address = requestDto.getAddress();
        this.simpleAddress = requestDto.getSimpleAddress();
        this.latitude = requestDto.getLatitude();
        this.longitude = requestDto.getLongitude();
    }
}
