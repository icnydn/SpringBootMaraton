package com.can.controller;

import com.can.dto.request.MarkaRequestDto;
import com.can.service.MarkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.can.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MARKA)
public class MarkaController {
    private final MarkaService markaService;

    @PostMapping(MARKAEKLE)
    public ResponseEntity<String> markaEkleme(@RequestBody MarkaRequestDto dto) {
        markaService.save(dto);
        return ResponseEntity.ok("İşlem Başarılı");
    }

}
