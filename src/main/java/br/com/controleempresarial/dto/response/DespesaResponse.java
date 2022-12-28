package br.com.controleempresarial.dto.response;

import br.com.controleempresarial.model.Despesa;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DespesaResponse {

    private Long id;
    private String fornecedor;
    private String categoria;
    private Long numeroDaNotaFiscal;
    private Double valorDaNotaFiscal;
    private LocalDate dataDeVencimento;
    private Boolean pago;

    public static DespesaResponse toDespesaResponse(Despesa despesa) {
        return new DespesaResponse(
                despesa.getId(),
                despesa.getFornecedor(),
                despesa.getCategoria(),
                despesa.getNumeroDaNotaFiscal(),
                despesa.getValorDaNotaFiscal(),
                despesa.getDataDeVencimento(),
                despesa.getPago()
        );
    }

}
