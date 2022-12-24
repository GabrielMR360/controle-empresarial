package br.com.controleempresarial.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FuncionarioPostRequestBody {

    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private LocalDate dataDeContratacao;
    private String cep;
    private String logradouro;
    private Integer numeroDaCasa;
    private String bairro;
    private String uf;

}
