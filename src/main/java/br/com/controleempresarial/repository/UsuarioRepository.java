package br.com.controleempresarial.repository;

import br.com.controleempresarial.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Boolean existsByCpf(String cpf);

}
