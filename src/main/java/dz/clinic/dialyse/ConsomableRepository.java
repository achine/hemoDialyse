package dz.clinic.dialyse;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.clinic.dialyse.model.Consomable;


public interface ConsomableRepository extends JpaRepository<Consomable,Long>{

	
	@Query("select consom from Consomable consom JOIN FETCH consom.caracts where consom.id=?1")
	List<Consomable> chercherConsomablesEtCaracts(Long id);
}
