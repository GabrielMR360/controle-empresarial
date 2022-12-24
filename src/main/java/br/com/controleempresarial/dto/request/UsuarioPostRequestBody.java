package br.com.controleempresarial.dto.request;

import br.com.controleempresarial.model.Endereco;
import lombok.Data;

@Data
public class UsuarioPostRequestBody {

    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private Endereco endereco;

}
