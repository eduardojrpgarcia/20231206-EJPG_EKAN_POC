package ejpg.ekan.poc.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
public class DocumentoDTO {

	@JsonProperty(value = "documento_id", access = Access.WRITE_ONLY)
	private String id;

	private String tipoDocumento;

	private String descricao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonProperty(value = "data_inclusao")
	private LocalDateTime dataInclusao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonProperty(value = "data_atualizacao")
	private LocalDateTime dataAtualizacao;
	
}
