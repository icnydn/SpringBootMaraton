package com.can.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {
    private Integer code;
    private String message;
    /**
     * String password: @Valid, min=9 max=32, Enaz bir Büyük Harf, bir Küçük Harf, Özel karakter....
     */
    private List<String> fields;
}
