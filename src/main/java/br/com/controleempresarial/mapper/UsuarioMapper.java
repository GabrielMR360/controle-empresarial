package br.com.controleempresarial.mapper;

import br.com.controleempresarial.dto.request.EnderecoRequest;
import br.com.controleempresarial.dto.request.UsuarioPostRequestBody;
import br.com.controleempresarial.model.Endereco;
import br.com.controleempresarial.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toUsuario(UsuarioPostRequestBody usuarioPostRequestBody);


}
