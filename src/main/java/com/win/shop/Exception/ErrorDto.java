package com.win.shop.Exception;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;
    private ErrorsCode errorsCode;
    private String message;
    private List<String> errors = new ArrayList<>();

}
