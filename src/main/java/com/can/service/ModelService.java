package com.can.service;

import com.can.dto.request.ModelRequestDto;
import com.can.entity.Model;

import com.can.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository repository;

    public Model save(Model model) {
        return repository.save(model);
    }


    public void save(ModelRequestDto dto) {
        repository.save(Model.builder().ad(dto.getAd()).build());
    }

    public Optional<Model> findByAd(String ad) {
        return repository.findByAdIgnoreCase(ad);
    }
}
