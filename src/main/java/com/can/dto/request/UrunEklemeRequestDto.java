package com.can.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrunEklemeRequestDto {
    String ad;
    String anaResim;
    String resim1;
    String resim2;
    String resim3;
    String marka;
    String model;
    Double fiyat;
}
