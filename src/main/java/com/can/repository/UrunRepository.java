package com.can.repository;

import com.can.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrunRepository extends JpaRepository<Urun, Long> {
}
