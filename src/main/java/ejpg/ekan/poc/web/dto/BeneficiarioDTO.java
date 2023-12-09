package ejpg.ekan.poc.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode
public class BeneficiarioDTO {
	
	@JsonProperty(value = "beneficiario_id", access = Access.WRITE_ONLY)
    private String id;

    private String nome;

    private String telefone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty(value = "data_nascimento")
    private LocalDate dataNascimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty(value = "data_inclusao")
    private LocalDateTime dataInclusao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty(value = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @JsonProperty(value = "documentos")
    private List<DocumentoDTO> documentos;

}
