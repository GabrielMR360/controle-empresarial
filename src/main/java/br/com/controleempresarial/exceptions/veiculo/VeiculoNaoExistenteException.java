package br.com.controleempresarial.exceptions.veiculo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VeiculoNaoExistenteException extends RuntimeException {

    public VeiculoNaoExistenteException(String message) {
        super(message);
    }

}
