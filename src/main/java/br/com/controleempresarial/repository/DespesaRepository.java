package br.com.controleempresarial.repository;

import br.com.controleempresarial.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    Boolean existsByNumeroDaNotaFiscal(Long numeroDaNF);

}
