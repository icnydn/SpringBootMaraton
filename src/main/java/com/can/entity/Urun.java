package com.can.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tblurun")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String anaResim;
    String resim1;
    String resim2;
    String resim3;
    @ManyToOne
    Marka marka;
    @ManyToOne
    Model model;
    Double fiyat;
}
