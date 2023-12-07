package ejpg.ekan.poc.web.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import ejpg.ekan.poc.data.dao.BeneficiarioDAO;
import ejpg.ekan.poc.data.domain.Beneficiario;
import ejpg.ekan.poc.web.dto.DocumentoDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ejpg.ekan.poc.data.domain.Documento;
import ejpg.ekan.poc.web.dto.BeneficiarioDTO;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class IBeneficiarioMapper {

    @Mapping(target = "id", source = "beneficiario.id")
    @Mapping(target = "nome", source = "beneficiario.nome")
    @Mapping(target = "telefone", source = "beneficiario.telefone")
    @Mapping(target = "dataNascimento", source = "beneficiario.dataNascimento")
    @Mapping(target = "dataInclusao", source = "beneficiario.dataInclusao")
    @Mapping(target = "dataAtualizacao", source = "beneficiario.dataAtualizacao")
//    @Mapping(target = "documentos", expression = "java(mapDocumentoDTOFromDocumento(beneficiario.getId()))")
	public abstract List<BeneficiarioDTO> mapBeneficiarioToBeneficiarioDTO(List<Beneficiario> beneficiario);

    @Mapping(target = "id", source = "doc.id")
    @Mapping(target = "tipoDocumento", source = "doc.tipoDocumento")
    @Mapping(target = "descricao", source = "doc.descricao")
    @Mapping(target = "dataInclusao", source = "doc.dataInclusao")
    @Mapping(target = "dataAtualizacao", source = "doc.dataAtualizacao")
    public abstract List<DocumentoDTO> mapDocumentoDTOFromDocumento(List<Documento> doc);

}
