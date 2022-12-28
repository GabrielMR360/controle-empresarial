package br.com.controleempresarial.controller;

import br.com.controleempresarial.dto.request.DespesaPostRequestBody;
import br.com.controleempresarial.dto.response.DespesaResponse;
import br.com.controleempresarial.service.DespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService despesaService;

    @PostMapping
    public ResponseEntity<DespesaResponse> cadastrar(@RequestBody DespesaPostRequestBody despesaRequest) {
        return new ResponseEntity<>(despesaService.cadastrar(despesaRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DespesaResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(despesaService.buscar(id));
    }

    @GetMapping
    public ResponseEntity<Page<DespesaResponse>> listarTodas(@PageableDefault(size = 5) Pageable paginacao) {
        return ResponseEntity.ok(despesaService.listarTodas(paginacao));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        despesaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
