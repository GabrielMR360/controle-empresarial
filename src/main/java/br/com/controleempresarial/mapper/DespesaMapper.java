package br.com.controleempresarial.mapper;

import br.com.controleempresarial.dto.request.DespesaPostRequestBody;
import br.com.controleempresarial.model.Despesa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DespesaMapper {

    DespesaMapper INSTANCE = Mappers.getMapper(DespesaMapper.class);

    Despesa toDespesa(DespesaPostRequestBody despesaPostRequestBody);

}
