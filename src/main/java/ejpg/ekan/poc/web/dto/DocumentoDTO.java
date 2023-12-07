package ejpg.ekan.poc.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
public class DocumentoDTO {

	@JsonProperty(value = "documento_id")
	private String id;

	@JsonProperty(value = "tipo_documento")
	private String tipoDocumento;

	private String descricao;

	@JsonProperty(value = "data_inclusao")
	private LocalDateTime dataInclusao;

	@JsonProperty(value = "data_atualizacao")
	private LocalDateTime dataAtualizacao;
	
}
