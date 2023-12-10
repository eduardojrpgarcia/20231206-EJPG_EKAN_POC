package ejpg.ekan.poc.data.domain;

import javax.persistence.*;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import ejpg.ekan.poc.data.domain.util.PersistentObject;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "DOCUMENTO")
@AttributeOverride(name = "id", column = @Column(name = "PK_DOCUMENTO"))
public class Documento extends PersistentObject {

	@ManyToOne
    @JoinColumn(name = "FK_BENEFICIARIO", nullable = false)
    private Beneficiario beneficiario;

	@Column(name = "TIPO_DOCUMENTO", nullable = false)
	private String tipoDocumento;

	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@Column(name = "DATA_INCLUSAO", nullable = false)
	private LocalDateTime dataInclusao;

	@Column(name = "DATA_ATUALIZACAO", nullable = false)
	private LocalDateTime dataAtualizacao;

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(beneficiario);
		builder.append(tipoDocumento);
		builder.append(descricao);
		builder.append(getId());
		return builder.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj instanceof Documento) {
			return obj.hashCode() == this.hashCode();
		}
		return false;
	}
    
}
