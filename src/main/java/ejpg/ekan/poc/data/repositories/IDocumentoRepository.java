package ejpg.ekan.poc.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ejpg.ekan.poc.data.domain.Documento;

import java.util.List;

@Repository
public interface IDocumentoRepository extends CrudRepository<Documento, String> {

    List<Documento> findByBeneficiario(String beneficiarioId);

}
