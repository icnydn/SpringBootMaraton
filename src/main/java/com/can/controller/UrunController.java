package com.can.controller;

import com.can.dto.request.UrunEklemeRequestDto;
import com.can.entity.Urun;
import com.can.entity.enums.Beden;
import com.can.entity.enums.Cinsiyet;
import com.can.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.can.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(URUN)
public class UrunController {
    private final UrunService urunService;

    @PostMapping(URUNEKLE)
    public ResponseEntity<String> urunEkleme(@RequestBody UrunEklemeRequestDto dto) {
        urunService.save(dto);
        return ResponseEntity.ok("İşlem Başarılı");
    }

    @PostMapping(GETALL)
    public ResponseEntity<List<Urun>> urunListele() {
        return ResponseEntity.ok(urunService.getAll());
    }

    @PostMapping(GETALLBYBEDEN)
    public ResponseEntity<List<Urun>> getAllByBeden(@RequestParam Beden beden) {
        return ResponseEntity.ok(urunService.getAllByBeden(beden));
    }

    @PostMapping(GETALLBYCINSIYET)
    public ResponseEntity<List<Urun>> getAllByCinsiyet(@RequestParam Cinsiyet cinsiyet) {
        return ResponseEntity.ok(urunService.getAllByCinsiyet(cinsiyet));
    }
}
