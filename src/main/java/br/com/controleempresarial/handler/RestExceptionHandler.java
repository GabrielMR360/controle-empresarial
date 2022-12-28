package br.com.controleempresarial.handler;

import br.com.controleempresarial.exceptions.ExceptionDetails;
import br.com.controleempresarial.exceptions.despesa.DespesaNaoExistenteException;
import br.com.controleempresarial.exceptions.despesa.NotaFiscalExistenteException;
import br.com.controleempresarial.exceptions.usuario.CpfExistenteException;
import br.com.controleempresarial.exceptions.usuario.UsuarioNaoExistenteException;
import br.com.controleempresarial.exceptions.veiculo.PlacaExistenteException;
import br.com.controleempresarial.exceptions.veiculo.VeiculoNaoExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends HandlerDetails {

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> exceptionHandler(UsuarioNaoExistenteException usuarioNaoExistenteException) {
        return super.handler(
                usuarioNaoExistenteException,
                "Bad Request Exception",
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> exceptionHandler(CpfExistenteException cpfExistenteException) {
        return super.handler(
                cpfExistenteException,
                "Conflict Exception",
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> exceptionHandler(NotaFiscalExistenteException notaFiscalExistenteException) {
        return super.handler(
                notaFiscalExistenteException,
                "Conflict Exception",
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> exceptionHandler(DespesaNaoExistenteException despesaNaoExistenteException) {
        return super.handler(
                despesaNaoExistenteException,
                "Bad Request Exception",
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> exceptionHandler(PlacaExistenteException placaExistenteException) {
        return super.handler(
                placaExistenteException,
                "Conflict Exception",
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> exceptionHandler(VeiculoNaoExistenteException veiculoNaoExistenteException) {
        return super.handler(
                veiculoNaoExistenteException,
                "Bad Request Exception",
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST);
    }

}