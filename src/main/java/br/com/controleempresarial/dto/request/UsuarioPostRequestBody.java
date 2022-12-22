package br.com.controleempresarial.dto.request;

import lombok.Data;

@Data
public class UsuarioPostRequestBody {

    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private String CEP;
    private String logradouro;
    private String numeroDaCasa;
    private String bairro;
    private String UF;

}
