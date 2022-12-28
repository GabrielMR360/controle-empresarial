package br.com.controleempresarial.dto.response;

import br.com.controleempresarial.model.Endereco;
import br.com.controleempresarial.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private Endereco endereco;

    public static UsuarioResponse toUsuarioResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getEndereco()
        );
    }

}
