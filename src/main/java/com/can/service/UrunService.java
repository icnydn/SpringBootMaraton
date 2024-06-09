package com.can.service;

import com.can.dto.request.UrunEklemeRequestDto;
import com.can.entity.Marka;
import com.can.entity.Model;
import com.can.entity.Urun;
import com.can.entity.UrunOzellik;
import com.can.entity.enums.Beden;
import com.can.entity.enums.Cinsiyet;
import com.can.exception.ErrorType;
import com.can.exception.EticaretException;
import com.can.repository.UrunOzellikRepository;
import com.can.repository.UrunRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UrunService {
    private final UrunRepository repository;
    private final ModelService modelService;
    private final MarkaService markaService;
    private final UrunOzellikRepository urunOzellikRepository;

    public Urun saveAndGetUrun(String ad, String anaResim, String resim1, String resim2,
                               String resim3, Marka marka, Model model, Double fiyat) {
        Urun urun = repository.save(Urun.builder()
                .ad(ad)
                .anaResim(anaResim)
                .resim1(resim1)
                .resim2(resim2)
                .resim3(resim3)
                .marka(marka)
                .model(model)
                .fiyat(fiyat)
                .build());
        return urun;
    }

    public void save(UrunEklemeRequestDto dto) {
        Urun urun = (Urun.builder()
                .ad(dto.getAd())
                .anaResim(dto.getAnaResim())
                .resim1(dto.getResim1())
                .resim2(dto.getResim2())
                .resim3(dto.getResim3())
                .fiyat(dto.getFiyat())
                .build());
        Optional<Marka> marka = markaService.findByAd(dto.getMarka());
        if (marka.isPresent()) {
            urun.setMarka(marka.get());
        } else {
            Marka marka1 = Marka.builder().ad(dto.getMarka()).build();
            Marka savingMarka = markaService.save(marka1);
            urun.setMarka(savingMarka);
        }
        Optional<Model> model = modelService.findByAd(dto.getModel());
        if (model.isPresent()) {
            urun.setModel(model.get());
        } else {
            Model model1 = Model.builder().ad(dto.getModel()).build();
            Model savingModel = modelService.save(model1);
            urun.setModel(savingModel);
        }
        repository.save(urun);
    }

    public List<Urun> getAll() {
        return repository.findAll();
    }

    public Urun findById(Long urunId) {
        return repository.findById(urunId).orElseThrow(() -> new EticaretException(ErrorType.NOT_FOUND_ERROR));
    }

    public List<Urun> getAllByBeden(Beden beden) {
        List<UrunOzellik> urunOzellikList = urunOzellikRepository.findAllByBeden(beden);
        List<Urun> urunList = new ArrayList<>();
        for (UrunOzellik urunOzellik : urunOzellikList) {
            urunList.add(urunOzellik.getUrun());
        }
        return urunList;
    }

    public List<Urun> getAllByCinsiyet(Cinsiyet cinsiyet) {
        List<UrunOzellik> urunOzellikList = urunOzellikRepository.findAllByCinsiyet(cinsiyet);
        List<Urun> urunList = new ArrayList<>();
        for (UrunOzellik urunOzellik : urunOzellikList) {
            urunList.add(urunOzellik.getUrun());
        }
        return urunList;
    }
}
