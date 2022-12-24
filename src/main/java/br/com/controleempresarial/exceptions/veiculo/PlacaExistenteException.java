package br.com.controleempresarial.exceptions.veiculo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PlacaExistenteException extends RuntimeException {

    public PlacaExistenteException(String message) {
        super(message);
    }

}
