package br.com.controleempresarial.service;

import br.com.controleempresarial.dto.request.FuncionarioPostRequestBody;
import br.com.controleempresarial.exceptions.usuario.UsuarioNaoExistenteException;
import br.com.controleempresarial.mapper.FuncionarioMapper;
import br.com.controleempresarial.model.Funcionario;
import br.com.controleempresarial.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public Funcionario cadastrar(FuncionarioPostRequestBody funcionarioRequest) {
        if (funcionarioRepository.existsByCpf(funcionarioRequest.getCpf()))
            throw new UsuarioNaoExistenteException("CPF já existente");

        return funcionarioRepository.save(FuncionarioMapper.INSTANCE.toFuncionario(funcionarioRequest));
    }

    public Funcionario buscar(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExistenteException("Funcionário não encontrado"));
    }


    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public void deletar(Long id) {
        if (!funcionarioRepository.existsById(id))
            throw new UsuarioNaoExistenteException("ID não encontrado");

        funcionarioRepository.deleteById(id);
    }
}
