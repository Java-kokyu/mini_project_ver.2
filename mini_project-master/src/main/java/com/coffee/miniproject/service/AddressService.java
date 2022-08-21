package com.coffee.miniproject.service;

import com.coffee.miniproject.dto.AddressRequestDto;
import com.coffee.miniproject.dto.AddressResponseDto;
import com.coffee.miniproject.model.Address;
import com.coffee.miniproject.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Transactional
    public AddressResponseDto createAddress(AddressRequestDto requestDto) {
        Address address = new Address(requestDto);
        addressRepository.save(address);

        return new AddressResponseDto(address);
    }
}
