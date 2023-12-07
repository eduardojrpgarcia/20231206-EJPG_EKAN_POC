package ejpg.ekan.poc.web.mapper;

import ejpg.ekan.poc.data.dao.BeneficiarioDAO;
import ejpg.ekan.poc.data.domain.Beneficiario;
import ejpg.ekan.poc.web.dto.DocumentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ejpg.ekan.poc.data.domain.Documento;
import ejpg.ekan.poc.web.dto.BeneficiarioDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class IBeneficiarioMapper {

    @Autowired
    BeneficiarioDAO beneficiarioDAO;

    @Mapping(target = "id", source = "beneficiario.id")
    @Mapping(target = "nome", source = "beneficiario.nome")
    @Mapping(target = "telefone", source = "beneficiario.telefone")
    @Mapping(target = "dataNascimento", source = "beneficiario.dataNascimento")
    @Mapping(target = "dataInclusao", source = "beneficiario.dataInclusao")
    @Mapping(target = "dataAtualizacao", source = "beneficiario.dataAtualizacao")
//    @Mapping(target = "documentos", expression = "java(mapDocumentoDTOFromDocumento(beneficiario.getId()))")
	public abstract List<BeneficiarioDTO> mapBeneficiarioToBeneficiarioDTO(List<Beneficiario> beneficiario);

//	public abstract Beneficiario mapBeneficiarioFromBeneficiarioDTO(BeneficiarioDTO dto);

//	public abstract List<Documento> mapDocumentoFromBeneficiarioDTO(BeneficiarioDTO dto);

    public List<DocumentoDTO> mapDocumentoDTOFromDocumento(String beneficiarioId) {
        List<Documento> documentos = beneficiarioDAO.listarTodosDocumentosDeBeneficiario(beneficiarioId);
        List<DocumentoDTO> documentosDTO = new ArrayList<>();
        for (Documento d : documentos) {
            DocumentoDTO dto = new DocumentoDTO();
            dto.setDocumentoId(d.getId());
            dto.setTipoDocumento(d.getTipoDocumento());
            dto.setDescricao(d.getDescricao());
            dto.setDataInclusao(d.getDataInclusao());
            dto.setDataAtualizacao(d.getDataAtualizacao());
            documentosDTO.add(dto);
        }
        return documentosDTO;
    }

}
