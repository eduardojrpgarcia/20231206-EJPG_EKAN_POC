package ejpg.ekan.poc.data.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ejpg.ekan.poc.data.domain.Beneficiario;
import ejpg.ekan.poc.data.domain.Documento;
import ejpg.ekan.poc.data.repositories.IBeneficiarioRepository;
import ejpg.ekan.poc.data.repositories.IDocumentoRepository;
import ejpg.ekan.poc.web.exception.RuntimeServiceException;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiarioDAO {
	
	private static final Logger logger = Logger.getLogger(BeneficiarioDAO.class);
	
    private IBeneficiarioRepository beneficiarioRepository;

	private IDocumentoRepository documentoRepository;
	
	@Autowired
	public BeneficiarioDAO(IBeneficiarioRepository beneficiarioRepository,
						IDocumentoRepository documentoRepository) {
		this.beneficiarioRepository = beneficiarioRepository;
		this.documentoRepository = documentoRepository;
	}

	public void salvarBeneficiario(Beneficiario beneficiario, List<Documento> documentos) {
		
		Beneficiario novoBeneficiario;
		
		if (ObjectUtils.isNotEmpty(beneficiario.getId())) {
			
			Optional<Beneficiario> optBeneficiario = this.beneficiarioRepository.findById(beneficiario.getId());
			
			if (optBeneficiario.isPresent()) {
				
				Beneficiario instancia = optBeneficiario.get();
				
				if (BooleanUtils.isTrue(instancia.getHidden())) {
					throw new RuntimeServiceException("TENTATIVA DE RECADASTRAMENTO DE BENEFICIARIO ID: " + instancia.getId());
				}
			}
			
		}
		
		if(ObjectUtils.isNotEmpty(beneficiario.getId())) {
			throw new RuntimeServiceException("TENTANTIVA DE CADASTRAMENTO DE BENEFICIARIO COM ID PREDEFINIDO: " + beneficiario.getId());
		}
		
		try {
			
			novoBeneficiario = this.beneficiarioRepository.save(beneficiario);
		
		} catch (RuntimeException e) {
			throw new RuntimeServiceException(e);
		}
		
		Boolean documentoRepetido = false;
		
		try {
			
			for (Documento documento : documentos) {
				
				documento.setBeneficiario(novoBeneficiario);
				
				List<Documento> documentoEncontrado = this.documentoRepository.findByDescricao(documento.getDescricao());
				
				if (ObjectUtils.isNotEmpty(documentoEncontrado)){
					
					final String ticket = UUID.randomUUID().toString();
					
					logger.warn("TICKET: [" + ticket + "] DOCUMENTO DUPLICADO EM NOVO BENEFICIARIO ID: " + novoBeneficiario.getId());

					
					for (Documento i : documentoEncontrado) {
					
						logger.warn("TICKET: [" + ticket + "] DOCUMENTO DUPLICADO ID: " + i.getId());
						
						Optional<Beneficiario> beneficiarioPreExtistente = this.beneficiarioRepository.findById(i.getBeneficiario().getId());
						
						if (beneficiarioPreExtistente.isPresent()) {
							
							logger.warn("TICKET: [" + ticket + "] PRE EXISTENTE BENEFICIARIO ID: " + beneficiarioPreExtistente.get().getId());
							
							if (BooleanUtils.isTrue(beneficiarioPreExtistente.get().getHidden())) {
								
								logger.warn("TICKET: [" + ticket + "] PRE EXISTENTE BENEFICIARIO ID: " + beneficiarioPreExtistente.get().getId()
										+ "ESTA COM STATUS DE DESABILITADO");			
								
							}
							
						}
						
						documentoRepetido = Boolean.TRUE;
					}
					
					Documento novoDocumento = this.documentoRepository.save(documento);
					
					logger.warn("TICKET: [" + ticket + "] NOVO DOCUMENTO ID : " + novoDocumento.getId());
					
					this.removerBeneficiario(novoBeneficiario.getId());
					
					logger.warn("TICKET: [" + ticket + "] NOVO BENEFIARIO ID: " + novoBeneficiario.getId() + " FOI DESABILITADO");
				}
				
				this.documentoRepository.save(documento);				
			}
			
			if (BooleanUtils.isTrue(documentoRepetido)) {
				throw new RuntimeServiceException();
			}
			
		} catch (RuntimeException e) {
			throw new RuntimeServiceException(e);
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
			throw new RuntimeServiceException(e);
		}
	}

	public List<Documento> listarTodosDocumentosDeBeneficiario(String beneficiarioId, String role) {
		try {
			List<Documento> listDocumento = null;
			
			Optional<Beneficiario> beneficiario = this.beneficiarioRepository.findById(beneficiarioId);
			
			if (beneficiario.isPresent()) {
				
				Beneficiario instancia = beneficiario.get();
				
				if(BooleanUtils.isTrue(instancia.getHidden())) {
					
					if (role.equals("ADMIN")) {
						listDocumento = this.documentoRepository.findByBeneficiario(beneficiarioId);						
					} else {
						throw new RuntimeException("USUARIO SEM PERMISSAO PARA BUSCA DE BENEFICIARIO ID: " + beneficiarioId);
					}
					
				}
				
				if (BooleanUtils.isFalse(instancia.getHidden())
						|| ObjectUtils.isEmpty(instancia.getHidden())) {
					listDocumento = this.documentoRepository.findByBeneficiario(beneficiarioId);
				}
				
			} else {
				throw new RuntimeServiceException("BENEFICIARIO NAO ENCONTRADO ID: " + beneficiarioId);
			}
			
			return listDocumento;
		} catch (RuntimeException e) {
			throw new RuntimeServiceException(e);
		}
	}
	
	public void atualizarDadosDeBeneficiario(Beneficiario beneficiario) {
		try {
			Beneficiario beneficiarioAtualizacao;
			
			if (beneficiario.getId() == null) {
				throw new RuntimeServiceException("IDENTIFICADOR DE BENEFICIARIO NAO INFORMADO");
			}

			if (beneficiario.getTelefone() == null) {
				throw new RuntimeServiceException("NAO FORAM INFORMADOS DADOS PERMITIDOS PARA ATUALIZACAO");
			}
			
			Optional<Beneficiario> b = this.beneficiarioRepository.findById(beneficiario.getId());
			if (b.isPresent()) {
				beneficiarioAtualizacao = b.get();
				
				if(BooleanUtils.isTrue(beneficiarioAtualizacao.getHidden())) {
					throw new RuntimeServiceException("SEM PERMISSAO PARA ATUALIZAR DADOS DE BENEFICIARIO ID: " + beneficiarioAtualizacao.getId());
				}
				
			} else {
				throw new RuntimeServiceException("BENEFICIARIO NAO ENCONTRADO ID: " + beneficiario.getId());
			}
			
			beneficiarioAtualizacao.setDataAtualizacao(LocalDateTime.now());
			beneficiarioAtualizacao.setTelefone(beneficiario.getTelefone());
			
			this.beneficiarioRepository.save(beneficiarioAtualizacao);
		} catch (RuntimeException e) {
			throw new RuntimeServiceException(e);
		}
	}
	
	public void removerBeneficiario(String beneficiarioId) {
		try {
			Optional<Beneficiario> b = this.beneficiarioRepository.findById(beneficiarioId);
			if (b.isPresent()) {
				Beneficiario instancia = b.get();
				
				if(BooleanUtils.isTrue(instancia.getHidden())) {
					throw new RuntimeServiceException("TENTATIVA DE REMOCAO DUPLICADA BENEFICIARIO ID: " + instancia.getId());
				}
			}	
			this.beneficiarioRepository.updateToHidden(true, beneficiarioId);
		} catch (RuntimeException e) {
			throw new RuntimeServiceException(e);
		}
	}

}
