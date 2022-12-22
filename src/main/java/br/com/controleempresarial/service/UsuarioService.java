package br.com.controleempresarial.service;

import br.com.controleempresarial.mapper.UsuarioMapper;
import br.com.controleempresarial.dto.request.UsuarioPostRequestBody;
import br.com.controleempresarial.model.Usuario;
import br.com.controleempresarial.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario cadastrar(UsuarioPostRequestBody usuarioRequest) {
        if (repository.existsByCpf(usuarioRequest.getCpf()))
            throw new IllegalArgumentException("CPF já existente");

        return repository.save(UsuarioMapper.INSTANCE.toUsuario(usuarioRequest));
    }

    public Usuario buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não encontrado"));
    }

}
