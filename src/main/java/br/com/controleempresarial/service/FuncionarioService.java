package br.com.controleempresarial.service;

import br.com.controleempresarial.dto.request.FuncionarioPostRequestBody;
import br.com.controleempresarial.dto.response.FuncionarioResponse;
import br.com.controleempresarial.exceptions.usuario.UsuarioNaoExistenteException;
import br.com.controleempresarial.mapper.FuncionarioMapper;
import br.com.controleempresarial.model.Funcionario;
import br.com.controleempresarial.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioResponse cadastrar(FuncionarioPostRequestBody funcionarioRequest) {
        if (funcionarioRepository.existsByCpf(funcionarioRequest.getCpf()))
            throw new UsuarioNaoExistenteException("CPF já existente");

        Funcionario funcionario = funcionarioRepository
                .save(FuncionarioMapper.INSTANCE.toFuncionario(funcionarioRequest));

        return FuncionarioResponse.toFuncionarioResponse(funcionario);
    }

    public FuncionarioResponse buscar(Long id) {
        return funcionarioRepository.findById(id)
                .map(funcionario -> FuncionarioResponse.toFuncionarioResponse(funcionario))
                .orElseThrow(() -> new UsuarioNaoExistenteException("Funcionário não encontrado"));
    }

    public Page<FuncionarioResponse> listarTodos(Pageable paginacao) {
        return funcionarioRepository.findAll(paginacao).map(resp -> FuncionarioResponse.toFuncionarioResponse(resp));
    }

    public void deletar(Long id) {
        if (!funcionarioRepository.existsById(id))
            throw new UsuarioNaoExistenteException("ID não encontrado");

        funcionarioRepository.deleteById(id);
    }
}
