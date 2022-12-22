package br.com.controleempresarial.controller;

import br.com.controleempresarial.dto.request.UsuarioPostRequestBody;
import br.com.controleempresarial.model.Usuario;
import br.com.controleempresarial.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioPostRequestBody usuario) {
        return new ResponseEntity<>(usuarioService.cadastrar(usuario), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscar(id));
    }
}
