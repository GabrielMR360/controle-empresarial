package br.com.controleempresarial.service;

import br.com.controleempresarial.dto.request.VeiculoPostRequestbody;
import br.com.controleempresarial.dto.response.VeiculoResponse;
import br.com.controleempresarial.exceptions.veiculo.PlacaExistenteException;
import br.com.controleempresarial.exceptions.veiculo.VeiculoNaoExistenteException;
import br.com.controleempresarial.mapper.VeiculoMapper;
import br.com.controleempresarial.model.Veiculo;
import br.com.controleempresarial.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoResponse cadastrar(VeiculoPostRequestbody veiculoRequest) {
        if (veiculoRepository.existsByPlaca(veiculoRequest.getPlaca()))
            throw new PlacaExistenteException("Placa já existe");

        Veiculo veiculo = veiculoRepository.save(VeiculoMapper.INSTANCE.toVeiculo(veiculoRequest));
        return VeiculoResponse.toVeiculoResponse(veiculo);
    }

    public VeiculoResponse buscar(Long id) {
        return veiculoRepository.findById(id)
                .map(veiculo -> VeiculoResponse.toVeiculoResponse(veiculo))
                .orElseThrow(() -> new VeiculoNaoExistenteException("Veículo não encontrado"));
    }

    public Page<VeiculoResponse> listarTodos(Pageable paginacao) {
        return veiculoRepository.findAll(paginacao).map(veiculo -> VeiculoResponse.toVeiculoResponse(veiculo));
    }

    public void deletar(Long id) {
        if (!veiculoRepository.existsById(id))
            throw new VeiculoNaoExistenteException("ID não encontrado");

        veiculoRepository.deleteById(id);
    }

    public Page<VeiculoResponse> listarTodosPeloAno(Integer ano, Pageable paginacao) {
        return veiculoRepository.findAllByAnoModelo(ano, paginacao)
                .map(veiculo -> VeiculoResponse.toVeiculoResponse(veiculo));
    }

}
