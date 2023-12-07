package ejpg.ekan.poc.data.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ejpg.ekan.poc.data.domain.util.PersistentObject;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "BENEFICIARIO")
@AttributeOverride(name = "id", column = @Column(name = "PK_BENEFICIARIO"))
public class Beneficiario extends PersistentObject {

	@Column(name = "NOME", nullable = false)
    private String nome;
	
	@Column(name = "TELEFONE", nullable = false)
    private String telefone;
	
	@Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;
	
	@Column(name = "DATA_INCLUSAO", nullable = false)
    private LocalDateTime dataInclusao;

	@Column(name = "DATA_ATUALIZACAO", nullable = false)
	private LocalDateTime dataAtualizacao;

	public static boolean isEmpty(Beneficiario beneficiario) {
		if (ObjectUtils.isEmpty(beneficiario)) {
			return true;
		} else {
			boolean bNome = ObjectUtils.isEmpty(beneficiario.getNome());
			boolean bTelefone = ObjectUtils.isEmpty(beneficiario.getTelefone());
			boolean bDataNascimento = ObjectUtils.isEmpty(beneficiario.getDataNascimento());
			boolean bDataInclusao = ObjectUtils.isEmpty(beneficiario.getDataInclusao());
			boolean bDataAtualizacao = ObjectUtils.isEmpty(beneficiario.getDataAtualizacao());
			boolean[] values = { bNome, bTelefone, bDataNascimento, bDataInclusao, bDataAtualizacao };
			for (int i = 0; i < values.length; i++) {
				if (values[i]) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder hashCode = new HashCodeBuilder();
		hashCode.append(nome);
		hashCode.append(telefone);
		hashCode.append(dataNascimento);
		hashCode.append(dataInclusao);
		hashCode.append(dataAtualizacao);
		hashCode.append(getId());
		return hashCode.build();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else if (obj instanceof Beneficiario) {
			return obj.hashCode() == hashCode();
		}
		return false;
	}
	
}
