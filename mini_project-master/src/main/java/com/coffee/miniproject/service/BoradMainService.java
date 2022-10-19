package com.coffee.miniproject.service;

import com.coffee.miniproject.dto.request.BoardMainRequestDto;
import com.coffee.miniproject.model.BoardMain;
import com.coffee.miniproject.repository.BoardMainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoradMainService {
    private final BoardMainRepository boardMainRepository;

    @Transactional
    public void saveBoardMain(BoardMainRequestDto requestDto) {
        BoardMain boardMain = requestDto.toEntity();
        boardMainRepository.save(boardMain);
    }
}
