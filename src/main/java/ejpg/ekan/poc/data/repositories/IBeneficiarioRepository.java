package ejpg.ekan.poc.data.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ejpg.ekan.poc.data.domain.Beneficiario;

@Repository
public interface IBeneficiarioRepository extends CrudRepository<Beneficiario, String> {
	
    Page<Beneficiario> findAll(Pageable page);
    
    @Modifying
    @Transactional
    @Query(value = "update Beneficiario b set b.hidden =?1 where b.id = ?2")
	void updateToHidden(boolean hidden, String beneficiarioId);
    
    @Query(value = "select b from Beneficiario b where b.hidden = false or b.hidden = null")
    List<Beneficiario> findByHiddenEqualFalse();
    
}
