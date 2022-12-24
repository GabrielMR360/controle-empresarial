package br.com.controleempresarial.mapper;

import br.com.controleempresarial.dto.request.VeiculoPostRequestbody;
import br.com.controleempresarial.model.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    VeiculoMapper INSTANCE = Mappers.getMapper(VeiculoMapper.class);

    Veiculo toVeiculo(VeiculoPostRequestbody veiculoPostRequestbody);

}
