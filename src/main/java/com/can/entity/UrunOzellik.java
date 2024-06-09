package com.can.entity;

import com.can.entity.enums.Beden;
import com.can.entity.enums.Cinsiyet;
import com.can.entity.enums.Kategori;
import com.can.entity.enums.Renk;
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
@Table(name = "tblurunozellik")
public class UrunOzellik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Urun urun;
    @Enumerated(EnumType.STRING)
    Kategori kategori;
    @Enumerated(EnumType.STRING)
    Beden beden;
    @Enumerated(EnumType.STRING)
    Cinsiyet cinsiyet;
    @Enumerated(EnumType.STRING)
    Renk renk;
}
