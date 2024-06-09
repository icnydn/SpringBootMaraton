package com.can.service;

import com.can.dto.request.MarkaRequestDto;
import com.can.entity.Marka;
import com.can.repository.MarkaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarkaService {
    private final MarkaRepository repository;

    public Marka save(Marka marka) {
        return repository.save(marka);
    }

    public void save(MarkaRequestDto dto) {
        repository.save(Marka.builder().ad(dto.getAd()).build());
    }

    public Optional<Marka> findByAd(String ad) {
        return repository.findByAdIgnoreCase(ad);
    }
}
