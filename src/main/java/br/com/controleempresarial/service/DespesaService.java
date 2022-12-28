package br.com.controleempresarial.service;

import br.com.controleempresarial.dto.request.DespesaPostRequestBody;
import br.com.controleempresarial.dto.response.DespesaResponse;
import br.com.controleempresarial.exceptions.despesa.DespesaNaoExistenteException;
import br.com.controleempresarial.exceptions.despesa.NotaFiscalExistenteException;
import br.com.controleempresarial.mapper.DespesaMapper;
import br.com.controleempresarial.model.Despesa;
import br.com.controleempresarial.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;

    public DespesaResponse cadastrar(DespesaPostRequestBody despesaRequest) {
        if (despesaRepository.existsByNumeroDaNotaFiscal(despesaRequest.getNumeroDaNotaFiscal()))
            throw new NotaFiscalExistenteException("Número da nota fiscal já existe");

        Despesa despesa = despesaRepository.save(DespesaMapper.INSTANCE.toDespesa(despesaRequest));
        return DespesaResponse.toDespesaResponse(despesa);
    }

    public DespesaResponse buscar(Long id) {
        return despesaRepository.findById(id)
                .map(despesa -> DespesaResponse.toDespesaResponse(despesa))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Despesa não encontrada"));
    }

    public Page<DespesaResponse> listarTodas(Pageable paginacao) {
        return despesaRepository.findAll(paginacao).map(despesa -> DespesaResponse.toDespesaResponse(despesa));
    }

    public void deletar(Long id) {
        if (!despesaRepository.existsById(id))
            throw new DespesaNaoExistenteException("Id não encontrado");
        despesaRepository.deleteById(id);
    }

}
