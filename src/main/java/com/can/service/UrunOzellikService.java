package com.can.service;

import com.can.dto.request.UrunOzellikDto;
import com.can.dto.request.UrunOzellikRequestDto;
import com.can.entity.Urun;
import com.can.entity.UrunOzellik;
import com.can.entity.enums.Beden;
import com.can.entity.enums.Cinsiyet;
import com.can.entity.enums.Kategori;
import com.can.entity.enums.Renk;
import com.can.repository.UrunOzellikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UrunOzellikService {
    private final UrunOzellikRepository repository;
    private final UrunService urunService;

    public void save(Long urunId, Kategori kategori, Beden beden, Cinsiyet cinsiyet, Renk renk) {
        Urun urun = urunService.findById(urunId);
        UrunOzellik urunOzellik = UrunOzellik.builder().urun(urun).kategori(kategori)
                .beden(beden).cinsiyet(cinsiyet).renk(renk).build();
        repository.save(urunOzellik);
    }

    public UrunOzellikDto getAll() {
        List<String> bedenList = new ArrayList<>();
        for (Beden value : Beden.values()) {
            bedenList.add(value.name());
        }
        List<String> kategoriList = new ArrayList<>();
        for (Kategori value : Kategori.values()) {
            kategoriList.add(value.name());
        }
        List<String> cinsiyetList = new ArrayList<>();
        for (Cinsiyet value : Cinsiyet.values()) {
            cinsiyetList.add(value.name());
        }
        List<String> renkList = new ArrayList<>();
        for (Renk value : Renk.values()) {
            renkList.add(value.name());
        }
        return UrunOzellikDto.builder().beden(bedenList).kategori(kategoriList).cinsiyet(cinsiyetList).renk(renkList).build();

    }
}
