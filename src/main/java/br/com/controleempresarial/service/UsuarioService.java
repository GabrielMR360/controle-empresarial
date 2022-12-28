package br.com.controleempresarial.service;

import br.com.controleempresarial.dto.request.UsuarioPostRequestBody;
import br.com.controleempresarial.dto.response.UsuarioResponse;
import br.com.controleempresarial.exceptions.usuario.CpfExistenteException;
import br.com.controleempresarial.exceptions.usuario.UsuarioNaoExistenteException;
import br.com.controleempresarial.mapper.UsuarioMapper;
import br.com.controleempresarial.model.Usuario;
import br.com.controleempresarial.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioResponse cadastrar(UsuarioPostRequestBody usuarioRequest) {
        if (repository.existsByCpf(usuarioRequest.getCpf()))
            throw new CpfExistenteException("CPF já existente");

        Usuario usuario = repository.save(UsuarioMapper.INSTANCE.toUsuario(usuarioRequest));
        return UsuarioResponse.toUsuarioResponse(usuario);
    }

    public UsuarioResponse buscar(Long id) {
        return repository.findById(id)
                .map(usuario -> UsuarioResponse.toUsuarioResponse(usuario))
                .orElseThrow(() -> new UsuarioNaoExistenteException("Usuario não encontrado"));
    }

    public Page<UsuarioResponse> listarTodos(Pageable paginacao) {
        return repository.findAll(paginacao)
                .map(usuario -> UsuarioResponse.toUsuarioResponse(usuario));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id))
            throw new UsuarioNaoExistenteException("ID não encontrado");
        repository.deleteById(id);
    }

}
