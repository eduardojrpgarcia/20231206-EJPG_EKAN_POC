package ejpg.ekan.poc.web.controller;

import ejpg.ekan.poc.data.dao.BeneficiarioDAO;
import ejpg.ekan.poc.web.dto.BeneficiarioDTO;
import ejpg.ekan.poc.web.dto.DocumentoDTO;
import ejpg.ekan.poc.web.mapper.IBeneficiarioMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping
	public ResponseEntity<HttpStatus> criarBeneficiario(@RequestBody BeneficiarioDTO beneficiario) {
        return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@GetMapping
	public ResponseEntity<List<BeneficiarioDTO>> buscarTodosBeneficiarios() {
		List<BeneficiarioDTO> beneficiarios = mapper.mapBeneficiarioToBeneficiarioDTO(dao.listarTodosBeneficiarios());
		return new ResponseEntity<>(beneficiarios, HttpStatus.OK);
	}

	@GetMapping("/documentos")
	public ResponseEntity<List<DocumentoDTO>> buscarTodosDocumentosDeBeneficiario(String benefiarioId) {
		return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
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
