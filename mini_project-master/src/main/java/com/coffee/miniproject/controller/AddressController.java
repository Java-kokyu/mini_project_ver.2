package com.coffee.miniproject.controller;

import com.coffee.miniproject.dto.AddressRequestDto;
import com.coffee.miniproject.dto.StatusResponseDto;
import com.coffee.miniproject.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private AddressService addressService;
    // 주소 등록, 현재는 post와 mapping 해서 사용
    @PostMapping("/api/address")
    public ResponseEntity<Object> postAddress(@RequestBody AddressRequestDto requestDto) {
        addressService.createAddress(requestDto);

        return new ResponseEntity<>(new StatusResponseDto("Success"), HttpStatus.OK);
    }
}
