package com.coffee.miniproject.controller;

import com.coffee.miniproject.dto.AddressRequestDto;
import com.coffee.miniproject.dto.AddressResponseDto;
import com.coffee.miniproject.dto.StatusResponseDto;
import com.coffee.miniproject.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    // 주소 등록, 현재는 post와 mapping 해서 사용
    @PostMapping("/api/address")
    public ResponseEntity<Object> postAddress(@RequestBody AddressRequestDto requestDto) {
        addressService.createAddress(requestDto);

        return new ResponseEntity<>(new StatusResponseDto("Success"), HttpStatus.OK);
    }

    // 주소 전체 조회 (사용 안할거 같지만 일단 넣기)
    @GetMapping("/api/address")
    public List<AddressResponseDto> getAllAddress() {
        return addressService.getAllAddress();
    }

    // 주소 상세 조회, 포스트와 Mapping 해서 조회 가능
    @GetMapping("/api/address/{id}")
    public AddressResponseDto getAddressDetail(@PathVariable Long id) {return addressService.getAddressDetail(id);}
}
