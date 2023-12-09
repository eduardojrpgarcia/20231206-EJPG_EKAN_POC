package ejpg.ekan.poc.data.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import ejpg.ekan.poc.data.domain.Beneficiario;
import ejpg.ekan.poc.data.domain.Documento;
import ejpg.ekan.poc.data.repositories.IBeneficiarioRepository;
import ejpg.ekan.poc.data.repositories.IDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiarioDAO {
	
    private IBeneficiarioRepository beneficiarioRepository;

	private IDocumentoRepository documentoRepository;

	@Autowired
	public BeneficiarioDAO(IBeneficiarioRepository beneficiarioRepository,
						IDocumentoRepository documentoRepository) {
		this.beneficiarioRepository = beneficiarioRepository;
		this.documentoRepository = documentoRepository;
	}

	public void salvarBeneficiario(Beneficiario beneficiario, List<Documento> documentos) {
		Beneficiario b;
		try {
			b = this.beneficiarioRepository.save(beneficiario);
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		} try {
			for (Documento d : documentos) {
				d.setBeneficiario(b);
				this.documentoRepository.save(d);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Beneficiario> listarTodosBeneficiarios() {
		try {
			List<Beneficiario> listBeneficiarios = new ArrayList<>();
			Iterable<Beneficiario> beneficiarios= this.beneficiarioRepository.findByHiddenEqualFalse();
			Iterator<Beneficiario> iterator = beneficiarios.iterator();
			while (iterator.hasNext()) {
				listBeneficiarios.add(iterator.next());
			}
			return listBeneficiarios;
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Documento> listarTodosDocumentosDeBeneficiario(String beneficiarioId) {
		try {
			List<Documento> listDocumento = this.documentoRepository.findByBeneficiario(beneficiarioId);
			return listDocumento;
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizarDadosDeBeneficiario(Beneficiario beneficiario) {
		try {
			Beneficiario beneficiarioAtualizacao;
			
			if (beneficiario.getId() == null) {
				throw new RuntimeException("Identificador de beneficiario não informado");
			}

			if (beneficiario.getTelefone() == null) {
				throw new RuntimeException("Não foram informados dados permitidos para atualizacao");
			}
			
			Optional<Beneficiario> b = this.beneficiarioRepository.findById(beneficiario.getId());
			if (b.isPresent()) {
				beneficiarioAtualizacao = b.get();
			} else {
				throw new RuntimeException("Beneficiario nao encontrado Identificador: " + beneficiario.getId());
			}
			
			beneficiarioAtualizacao.setDataAtualizacao(LocalDateTime.now());
			beneficiarioAtualizacao.setTelefone(beneficiario.getTelefone());
			
			this.beneficiarioRepository.save(beneficiarioAtualizacao);
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void removerBeneficiario(String beneficiarioId) {
		try {
			this.beneficiarioRepository.updateToHidden(true, beneficiarioId);
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

}
