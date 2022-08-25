package com.coffee.miniproject.controller;

import com.coffee.miniproject.dto.ImageRequestDto;
import com.coffee.miniproject.dto.PostRequestDto;
import com.coffee.miniproject.model.Post;
import com.coffee.miniproject.model.result.MultipleResult;
import com.coffee.miniproject.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImageUploadController {
    private final ImageUploadService imageUploadService;

    @PostMapping("/api/post/image")
    public HashMap<ImageRequestDto, ImageRequestDto> uploadImages(@RequestParam(value = "file", required = false)List<MultipartFile> multipartFiles) {
        return imageUploadService.uploadPostImages(multipartFiles, dir);
    }
}
