package br.com.controleempresarial.service;

import br.com.controleempresarial.dto.request.UsuarioPostRequestBody;
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

    public Usuario cadastrar(UsuarioPostRequestBody usuarioRequest) {
        if (repository.existsByCpf(usuarioRequest.getCpf()))
            throw new CpfExistenteException("CPF já existente");

        return repository.save(UsuarioMapper.INSTANCE.toUsuario(usuarioRequest));
    }

    public Usuario buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExistenteException("Usuario não encontrado"));
    }

    public Page<Usuario> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id))
            throw new UsuarioNaoExistenteException("ID não encontrado");
        repository.deleteById(id);
    }

}
