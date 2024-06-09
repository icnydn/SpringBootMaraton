package com.can.controller;


import com.can.dto.request.UrunOzellikDto;
import com.can.dto.request.UrunOzellikRequestDto;
import com.can.entity.UrunOzellik;
import com.can.entity.enums.Beden;
import com.can.entity.enums.Cinsiyet;
import com.can.entity.enums.Kategori;
import com.can.entity.enums.Renk;
import com.can.service.UrunOzellikService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.can.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(URUNOZELLIK)
public class UrunOzellikController {
    private final UrunOzellikService urunOzellikService;

    @PostMapping(OZELLIKEKLE)
    public ResponseEntity<String> ozellikEkleme(@RequestParam Long urunId, @RequestParam Kategori kategori, @RequestParam Beden beden, @RequestParam Cinsiyet cinsiyet, @RequestParam Renk renk) {
        urunOzellikService.save(urunId, kategori, beden, cinsiyet, renk);
        return ResponseEntity.ok("İşlem Başarılı");
    }

    @PostMapping(OZELLIKLISTESI)
    public ResponseEntity<UrunOzellikDto> ozellikListesi() {
        return ResponseEntity.ok(urunOzellikService.getAll());
    }
}
