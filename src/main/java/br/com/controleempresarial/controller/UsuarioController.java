package br.com.controleempresarial.controller;

import br.com.controleempresarial.dto.request.UsuarioPostRequestBody;
import br.com.controleempresarial.dto.response.UsuarioResponse;
import br.com.controleempresarial.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody UsuarioPostRequestBody usuario) {
        return new ResponseEntity<>(usuarioService.cadastrar(usuario), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscar(id));
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioResponse>> listarTodos(@PageableDefault(size = 5, sort = "nome") Pageable paginacao) {
        return ResponseEntity.ok(usuarioService.listarTodos(paginacao));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
