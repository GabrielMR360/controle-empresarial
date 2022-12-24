package br.com.controleempresarial.repository;

import br.com.controleempresarial.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Boolean existsByPlaca(String placa);

}
