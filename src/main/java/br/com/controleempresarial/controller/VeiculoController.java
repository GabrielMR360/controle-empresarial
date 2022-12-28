package br.com.controleempresarial.controller;

import br.com.controleempresarial.dto.request.VeiculoPostRequestbody;
import br.com.controleempresarial.dto.response.VeiculoResponse;
import br.com.controleempresarial.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoResponse> cadastrar(@RequestBody VeiculoPostRequestbody veiculoRequest) {
        return new ResponseEntity<>(veiculoService.cadastrar(veiculoRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VeiculoResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.buscar(id));
    }

    @GetMapping(path = "/ano-modelo={ano}")
    public ResponseEntity<Page<VeiculoResponse>> listarTodosPeloAno(
            @PageableDefault(size = 5) @PathVariable Integer ano, Pageable paginacao) {
        return ResponseEntity.ok(veiculoService.listarTodosPeloAno(ano, paginacao));
    }

    @GetMapping
    public ResponseEntity<Page<VeiculoResponse>> listarTodos(@PageableDefault(size = 5) Pageable paginacao) {
        return ResponseEntity.ok(veiculoService.listarTodos(paginacao));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
