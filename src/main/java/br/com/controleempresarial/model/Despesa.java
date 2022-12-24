package br.com.controleempresarial.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "despesas")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fornecedor;
    private String categoria;
    private Long numeroDaNotaFiscal;
    private Double valorDaNotaFiscal;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeVencimento;
    private Boolean pago;

}
