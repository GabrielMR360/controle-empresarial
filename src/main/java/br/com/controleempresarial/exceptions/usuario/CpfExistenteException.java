package br.com.controleempresarial.exceptions.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CpfExistenteException extends RuntimeException {

    public CpfExistenteException(String message) {
        super(message);
    }

}
