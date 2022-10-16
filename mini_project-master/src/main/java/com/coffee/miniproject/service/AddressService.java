package com.coffee.miniproject.service;

import com.coffee.miniproject.dto.request.AddressRequestDto;
import com.coffee.miniproject.dto.response.AddressResponseDto;
import com.coffee.miniproject.dto.response.StatusResponseDto;
import com.coffee.miniproject.model.Address;
import com.coffee.miniproject.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Transactional
    public ResponseEntity<Object> createAddress(AddressRequestDto requestDto) {
        Address address = new Address(requestDto);
        addressRepository.save(address);


        // return new AddressResponseDto(address);
        return new ResponseEntity<>(new StatusResponseDto("Success"), HttpStatus.OK);
    }

    public List<AddressResponseDto> getAllAddress() {
        List<Address> addressList;
        List<AddressResponseDto> addressResponseDtoList = new ArrayList<>();

        addressList = addressRepository.findAll();

        for (Address address : addressList) {
            AddressResponseDto addressResponseDto = new AddressResponseDto(address);
            addressResponseDtoList.add(addressResponseDto);
        }

        return addressResponseDtoList;
    }

    public AddressResponseDto getAddressDetail(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ID값이 올바르지 않습니다.")
        );

        return new AddressResponseDto(address);
    }
}
