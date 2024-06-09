package com.can.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrunOzellikDto {
    List<String> kategori;
    List<String> beden;
    List<String> cinsiyet;
    List<String> renk;

}
