package br.com.controleempresarial.exceptions.despesa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NotaFiscalExistenteException extends RuntimeException {

    public NotaFiscalExistenteException(String message) {
        super(message);
    }

}
