package com.can.repository;

import com.can.entity.Marka;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarkaRepository extends JpaRepository<Marka, Long> {
    Optional<Marka> findByAdIgnoreCase(String ad);
}
