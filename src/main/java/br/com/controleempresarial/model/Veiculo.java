package br.com.controleempresarial.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private String placa;
    private String marca;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private LocalDate dataDaCompra;
    private Boolean ipvaVencido;

}
