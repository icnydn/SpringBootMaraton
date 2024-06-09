package com.can.dto.request;

import com.can.entity.Urun;
import com.can.entity.enums.Beden;
import com.can.entity.enums.Cinsiyet;
import com.can.entity.enums.Kategori;
import com.can.entity.enums.Renk;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrunOzellikRequestDto {

    Urun urun;
    Kategori kategori;
    Beden beden;
    Cinsiyet cinsiyet;
    Renk renk;
    String aciklama;

}
