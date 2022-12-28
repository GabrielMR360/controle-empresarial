package br.com.controleempresarial.dto.response;

import br.com.controleempresarial.model.Endereco;
import br.com.controleempresarial.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class FuncionarioResponse {

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private LocalDate dataDeContratacao;
    private Endereco endereco;

    public static FuncionarioResponse toFuncionarioResponse(Funcionario funcionario) {
        return new FuncionarioResponse(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getTelefone(),
                funcionario.getCpf(),
                funcionario.getEmail(),
                funcionario.getDataDeContratacao(),
                funcionario.getEndereco()
        );
    }

}
