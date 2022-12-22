package br.com.controleempresarial.handler;

import br.com.controleempresarial.exceptions.usuario.CpfExistenteException;
import br.com.controleempresarial.exceptions.usuario.UsuarioNaoExistenteException;
import br.com.controleempresarial.exceptions.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> handlerBadRequestException(UsuarioNaoExistenteException badRequestException) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Bad Request Exception")
                        .details(badRequestException.getMessage())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .error(badRequestException.getClass().getName())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> handlerCpfExistenteException(CpfExistenteException cpfExistenteException) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Conflict Exception")
                        .details(cpfExistenteException.getMessage())
                        .status(HttpStatus.CONFLICT.value())
                        .error(cpfExistenteException.getClass().getName())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.CONFLICT
        );
    }

}
