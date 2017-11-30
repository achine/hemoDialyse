package dz.clinic.dialyse;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.clinic.dialyse.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long>{

	
	List<Patient> findByDateBetween(LocalDate date1,LocalDate date2);
	
	List<Patient> findByNameLike(String name);
	//LEFT JOIN Detailspatient det on pat.id = det.patient_id
	//But chercher des donnees presentes ds plusieurs tables jointure
	@Query("select pat from Patient pat JOIN FETCH pat.details where pat.id=?1")
	List<Patient> chercherPatientsEtDetails(Long id);
	
}
