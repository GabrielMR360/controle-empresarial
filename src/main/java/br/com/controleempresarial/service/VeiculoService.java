package br.com.controleempresarial.service;

import br.com.controleempresarial.dto.request.VeiculoPostRequestbody;
import br.com.controleempresarial.exceptions.veiculo.PlacaExistenteException;
import br.com.controleempresarial.exceptions.veiculo.VeiculoNaoExistenteException;
import br.com.controleempresarial.mapper.VeiculoMapper;
import br.com.controleempresarial.model.Veiculo;
import br.com.controleempresarial.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public Veiculo cadastrar(VeiculoPostRequestbody veiculoRequest) {
        if (veiculoRepository.existsByPlaca(veiculoRequest.getPlaca()))
            throw new PlacaExistenteException("Placa já existe");

        return veiculoRepository.save(VeiculoMapper.INSTANCE.toVeiculo(veiculoRequest));
    }

    public Veiculo buscar(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new VeiculoNaoExistenteException("Veículo não encontrado"));
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public void deletar(Long id) {
        if (!veiculoRepository.existsById(id))
            throw new VeiculoNaoExistenteException("ID não encontrado");

        veiculoRepository.deleteById(id);
    }

    public List<Veiculo> listarTodosPeloAno(Integer ano) {
        return veiculoRepository.findAllByAnoModelo(ano);
    }
}
