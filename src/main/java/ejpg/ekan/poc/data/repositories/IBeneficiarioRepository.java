package ejpg.ekan.poc.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ejpg.ekan.poc.data.domain.Beneficiario;

@Repository
public interface IBeneficiarioRepository extends CrudRepository<Beneficiario, String> {

}
