package com.can.repository;

import com.can.entity.UrunOzellik;
import com.can.entity.enums.Beden;
import com.can.entity.enums.Cinsiyet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrunOzellikRepository extends JpaRepository<UrunOzellik, Long> {
    List<UrunOzellik> findAllByBeden(Beden beden);

    List<UrunOzellik> findAllByCinsiyet(Cinsiyet cinsiyet);

}
