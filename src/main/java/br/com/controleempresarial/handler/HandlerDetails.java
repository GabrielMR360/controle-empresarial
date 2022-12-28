package br.com.controleempresarial.handler;

import br.com.controleempresarial.exceptions.ExceptionDetails;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class HandlerDetails {

    public ResponseEntity<ExceptionDetails> handler(
            RuntimeException runtimeException, String titulo, Integer httpStatus, HttpStatusCode httpStatusCode) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title(titulo)
                        .details(runtimeException.getMessage())
                        .status(httpStatus)
                        .error(runtimeException.getClass().getName())
                        .timestamp(LocalDateTime.now())
                        .build(), httpStatusCode
        );
    }

}
