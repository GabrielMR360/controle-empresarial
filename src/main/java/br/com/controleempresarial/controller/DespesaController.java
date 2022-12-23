package br.com.controleempresarial.controller;

import br.com.controleempresarial.dto.request.DespesaPostRequestBody;
import br.com.controleempresarial.model.Despesa;
import br.com.controleempresarial.service.DespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService despesaService;

    @PostMapping
    public ResponseEntity<Despesa> cadastrar(@RequestBody DespesaPostRequestBody despesaRequest) {
        return new ResponseEntity<>(despesaService.cadastrar(despesaRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Despesa> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(despesaService.buscar(id));
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> listarTodas() {
        return ResponseEntity.ok(despesaService.listarTodas());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        despesaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
