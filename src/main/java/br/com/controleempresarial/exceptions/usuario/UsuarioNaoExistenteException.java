package br.com.controleempresarial.exceptions.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioNaoExistenteException extends RuntimeException {

    public UsuarioNaoExistenteException(String message) {
        super(message);
    }

}
