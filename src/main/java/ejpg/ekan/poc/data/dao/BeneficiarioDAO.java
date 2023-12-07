package ejpg.ekan.poc.data.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	public void criarBeneficiario(Beneficiario beneficiario, List<Documento> documentos) {
		this.beneficiarioRepository.save(beneficiario);
		for (Documento d : documentos) {
			this.documentoRepository.save(d);
		}
	}

	public List<Beneficiario> listarTodosBeneficiarios() {
		try {
			List<Beneficiario> listBeneficiarios = new ArrayList<>();
			Iterable<Beneficiario> beneficiarios= this.beneficiarioRepository.findAll();
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
		this.beneficiarioRepository.save(beneficiario);
	}
	
	public void removerBeneficiario(String beneficiarioId) {
		this.beneficiarioRepository.deleteById(beneficiarioId);
	}

}
