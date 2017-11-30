package dz.clinic.dialyse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dz.clinic.dialyse.PatientRepository;
import dz.clinic.dialyse.model.DetailsPatient;
import dz.clinic.dialyse.model.Patient;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class HemoDialyseMainAppSBTests {

	@Autowired
	PatientRepository patientRepo;
	@Test
	public void createPatientTest() {
		
		Patient premierPatient = new Patient();
		
		premierPatient.setName("zouhir");
		premierPatient.setDate(LocalDate.of(2017, 11, 22));
		patientRepo.save(premierPatient);
		Assert.assertTrue(premierPatient.getId()>0);
		
		Patient patient2 = new Patient();
		patient2.setName("zouhir2AvecDetails");
		patient2.setDate(LocalDate.of(2017, 12, 23));
		
		DetailsPatient detail=new DetailsPatient();
		detail.setAdresse("rue LAVIE");
		detail.setPatient(patient2);
		List<DetailsPatient> listeDetails= new ArrayList<DetailsPatient>();
		
		listeDetails.add(detail);
		patient2.setDetails(listeDetails);
		
		patientRepo.save(patient2);
		
		Assert.assertTrue(patient2.getId()>1);
	}

}
