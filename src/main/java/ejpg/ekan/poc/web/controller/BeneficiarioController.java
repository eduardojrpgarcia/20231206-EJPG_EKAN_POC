package ejpg.ekan.poc.web.controller;

import ejpg.ekan.poc.data.dao.BeneficiarioDAO;
import ejpg.ekan.poc.web.dto.BeneficiarioDTO;
import ejpg.ekan.poc.web.dto.DocumentoDTO;
import ejpg.ekan.poc.web.mapper.IBeneficiarioMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

@RestController
@RequestMapping(value = "/beneficiario")
public class BeneficiarioController {

	IBeneficiarioMapper mapper = Mappers.getMapper(IBeneficiarioMapper.class);

	private BeneficiarioDAO dao;

	@Autowired
	public BeneficiarioController(BeneficiarioDAO dao) {
		this.dao = dao;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> criarBeneficiario(@RequestBody BeneficiarioDTO beneficiario) {
		dao.salvarBeneficiario(mapper.mapBeneficiarioDTOToBeneficiario(beneficiario),
				mapper.mapDocumentoDTOToDocumento(beneficiario.getDocumentos()));
        return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@GetMapping
	public ResponseEntity<List<BeneficiarioDTO>> buscarTodosBeneficiarios() {
		List<BeneficiarioDTO> beneficiarios = mapper.mapBeneficiarioToBeneficiarioDTO(dao.listarTodosBeneficiarios());
		return new ResponseEntity<>(beneficiarios, HttpStatus.OK);
	}

	@GetMapping("/documentos")
	public ResponseEntity<List<DocumentoDTO>> buscarTodosDocumentosDeBeneficiario(@RequestParam(name = "beneficiarioId") String benefiarioId) {
		List<DocumentoDTO> documentos = mapper.mapDocumentoDTOFromDocumento(dao.listarTodosDocumentosDeBeneficiario(benefiarioId));
		return new ResponseEntity<>(documentos, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@PutMapping
	public ResponseEntity<HttpStatus> atualizarDadosBeneficiario(@RequestBody BeneficiarioDTO beneficiario) {
		return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@DeleteMapping
	public ResponseEntity<HttpStatus> removerBeneficiario(@RequestBody String beneficiarioId) {
		return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
	}

}
