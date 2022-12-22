package br.com.controleempresarial.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DespesaPostRequestBody {

    private String fornecedor;
    private String categoria;
    private Long numeroDaNotaFiscal;
    private Double valorDaNotaFiscal;
    private LocalDate dataDeVencimento;
    private Boolean pago;

}
