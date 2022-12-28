package br.com.controleempresarial.controller;

import br.com.controleempresarial.dto.request.FuncionarioPostRequestBody;
import br.com.controleempresarial.dto.response.FuncionarioResponse;
import br.com.controleempresarial.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    // CriarFuncionarioRequest
    @PostMapping
    public ResponseEntity<FuncionarioResponse> cadastrar(@RequestBody FuncionarioPostRequestBody funcionarioRequest) {
        return new ResponseEntity<>(funcionarioService.cadastrar(funcionarioRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FuncionarioResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.buscar(id));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponse>> listarTodos() {
        return ResponseEntity.ok(funcionarioService.listarTodos());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
