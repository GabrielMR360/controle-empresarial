package br.com.controleempresarial.controller;

import br.com.controleempresarial.dto.request.VeiculoPostRequestbody;
import br.com.controleempresarial.model.Veiculo;
import br.com.controleempresarial.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> cadastrar(@RequestBody VeiculoPostRequestbody veiculoRequest) {
        return new ResponseEntity<>(veiculoService.cadastrar(veiculoRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Veiculo> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.buscar(id));
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos() {
        return ResponseEntity.ok(veiculoService.listarTodos());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
