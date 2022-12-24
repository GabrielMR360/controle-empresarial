package br.com.controleempresarial.dto.request;

import br.com.controleempresarial.model.Endereco;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FuncionarioPostRequestBody {

    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private LocalDate dataDeContratacao;
    private Endereco endereco;

}
