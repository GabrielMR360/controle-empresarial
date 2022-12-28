package br.com.controleempresarial.dto.response;

import br.com.controleempresarial.model.Tipo;
import br.com.controleempresarial.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class VeiculoResponse {

    private Long id;
    private String descricao;
    private Tipo tipo;
    private String placa;
    private String marca;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private LocalDate dataDaCompra;
    private Boolean ipvaVencido;

    public static VeiculoResponse toVeiculoResponse(Veiculo veiculo) {
        return new VeiculoResponse(
                veiculo.getId(),
                veiculo.getDescricao(),
                veiculo.getTipo(),
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getAnoFabricacao(),
                veiculo.getAnoModelo(),
                veiculo.getDataDaCompra(),
                veiculo.getIpvaVencido()
        );
    }

}
