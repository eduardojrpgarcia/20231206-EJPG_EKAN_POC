package ejpg.ekan.poc.web.mapper;

import ejpg.ekan.poc.data.domain.Beneficiario;
import ejpg.ekan.poc.web.dto.DocumentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ejpg.ekan.poc.data.domain.Documento;
import ejpg.ekan.poc.web.dto.BeneficiarioDTO;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class IBeneficiarioMapper {

    @Mapping(target = "id", source = "beneficiario.id")
    @Mapping(target = "nome", source = "beneficiario.nome")
    @Mapping(target = "telefone", source = "beneficiario.telefone")
    @Mapping(target = "dataNascimento", source = "beneficiario.dataNascimento")
    @Mapping(target = "dataInclusao", source = "beneficiario.dataInclusao")
    @Mapping(target = "dataAtualizacao", source = "beneficiario.dataAtualizacao")
	public abstract List<BeneficiarioDTO> mapBeneficiarioToBeneficiarioDTO(List<Beneficiario> beneficiario);

    @Mapping(target = "id", source = "doc.id")
    @Mapping(target = "tipoDocumento", source = "doc.tipoDocumento")
    @Mapping(target = "descricao", source = "doc.descricao")
    @Mapping(target = "dataInclusao", source = "doc.dataInclusao")
    @Mapping(target = "dataAtualizacao", source = "doc.dataAtualizacao")
    public abstract List<DocumentoDTO> mapDocumentoDTOFromDocumento(List<Documento> doc);
    
    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "nome", source = "dto.nome")
    @Mapping(target = "telefone", source = "dto.telefone")
    @Mapping(target = "dataNascimento", source = "dto.dataNascimento")
    @Mapping(target = "dataInclusao", source = "dto.dataInclusao")
    @Mapping(target = "dataAtualizacao", source = "dto.dataAtualizacao")
    public abstract Beneficiario mapBeneficiarioDTOToBeneficiario(BeneficiarioDTO dto);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "tipoDocumento", source = "dto.tipoDocumento")
    @Mapping(target = "descricao", source = "dto.descricao")
    @Mapping(target = "dataInclusao", source = "dto.dataInclusao")
    @Mapping(target = "dataAtualizacao", source = "dto.dataAtualizacao")
    public abstract List<Documento> mapDocumentoDTOToDocumento(List<DocumentoDTO> dto);

}
