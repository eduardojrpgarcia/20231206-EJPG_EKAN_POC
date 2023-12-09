package ejpg.ekan.poc.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ejpg.ekan.poc.data.domain.Beneficiario;

@Repository
public interface IBeneficiarioRepository extends CrudRepository<Beneficiario, String> {

    Page<Beneficiario> findAll(Pageable page);

}
