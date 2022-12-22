package br.com.controleempresarial.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {

    private String title;
    private String details;
    private Integer status;
    private String error;
    private LocalDateTime timestamp;

}
