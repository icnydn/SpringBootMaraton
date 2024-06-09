package com.can.repository;

import com.can.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {

    Optional<Model> findByAdIgnoreCase(String ad);
}
