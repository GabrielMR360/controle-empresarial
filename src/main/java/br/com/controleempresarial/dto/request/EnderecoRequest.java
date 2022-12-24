package br.com.controleempresarial.dto.request;

import lombok.Data;

@Data
public class EnderecoRequest {

    private String cep;
    private String logradouro;
    private String numeroDaCasa;
    private String bairro;
    private String uf;

}
