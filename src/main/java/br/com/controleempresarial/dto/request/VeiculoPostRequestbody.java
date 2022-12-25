package br.com.controleempresarial.dto.request;

import br.com.controleempresarial.model.Tipo;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VeiculoPostRequestbody {

    private String descricao;
    private Tipo tipo;
    private String placa;
    private String marca;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private LocalDate dataDaCompra;
    private Boolean ipvaVencido;

}
