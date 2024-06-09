package com.can.controller;

import com.can.dto.request.ModelRequestDto;
import com.can.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.can.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MODEL)
public class ModelController {
    private final ModelService modelService;

    @PostMapping(MODELEKLE)
    public ResponseEntity<String> modelEkleme(@RequestBody ModelRequestDto dto) {
        modelService.save(dto);
        return ResponseEntity.ok("İşlem Başarılı");
    }
}
