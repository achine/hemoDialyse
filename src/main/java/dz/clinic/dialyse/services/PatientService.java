package dz.clinic.dialyse.services;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.clinic.dialyse.PatientRepository;
import dz.clinic.dialyse.model.Patient;

@Service

public class PatientService {

	private static Logger logger = LoggerFactory.getLogger(PatientService.class);
	
	@Autowired PatientRepository patientRepo;
	 
	public List<Patient> findByDate(LocalDate dateNce){
		 if(dateNce==null){
			 logger.error("Argument date null inacceptable!");
			 return new ArrayList<Patient>();
		 }
		 //LocalDate dateNce1=dateNce. //new Date(dateNce.getTime()-(24*60*60*1000));//dateNce-1;
		 //LocalDate dateNce2= //new Date(dateNce.getTime()+(24*60*60*1000));//dateNce+1;
		 List<Patient> liste = patientRepo.findByDateBetween(dateNce,dateNce);
		 
		  List<Patient> listeFiltree = filtrerListe(liste);
		 
		 return  listeFiltree;
	 }
	 
	 
	 public List<Patient> findByNameLike(String name){
		 return patientRepo.findByNameLike(name);
	 }
	 
	 
	 public List<Patient> chercherPatientsEtDetails(Long id){
		 
		 return patientRepo.chercherPatientsEtDetails(id);
	 }
	 
	 
	private List<Patient> filtrerListe(List<Patient> liste) {
		// TODO Auto-generated method stub
		return liste;
	}
}
