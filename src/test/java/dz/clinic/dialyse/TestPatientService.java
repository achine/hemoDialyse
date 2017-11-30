package dz.clinic.dialyse;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import dz.clinic.dialyse.model.DetailsPatient;
import dz.clinic.dialyse.model.Patient;
import dz.clinic.dialyse.services.PatientService;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Sql(scripts={"classpath:cleandb.sql","classpath:data.sql"})
public class TestPatientService {

	@Autowired PatientService patientService;
	
	@Test
	public void testFindByDateCaseDateIsNull() {
		
		List<Patient> liste = patientService.findByDate(null); 
		
		Assert.assertTrue(liste.size()==0);
	}

	
	@Test
	public void testFindByDateCaseDateIsNotNull() {
		
		LocalDate localDate =LocalDate.of(2017,11,23);
		
		//Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		List<Patient> liste = patientService.findByDate(localDate);
		
		Assert.assertTrue(1 == liste.size());
		
		Patient patientFound = liste.get(0);
		
		Assert.assertEquals("testZouheir2", patientFound.getName());
		
	}
	
	@Test
	public void testFindByNameLike() {
		
		String nameLike = "%ir2%";
		
		List<Patient> liste = patientService.findByNameLike(nameLike);
		
		Assert.assertTrue(1 == liste.size());
	}
	
	@Test
	public void testChercherPatientsEtDetails() {
		  List<Patient> liste = patientService.chercherPatientsEtDetails(0L);
		  
		  Assert.assertTrue(1 == liste.size());
		  
		  Assert.assertEquals(liste.get(0).getDetails().size(), 1);
		  
		  DetailsPatient detailsFound = liste.get(0).getDetails().get(0);
		  
		  Assert.assertEquals("rue test integ Annaba", detailsFound.getAdresse());
		  
		  Assert.assertEquals(0, detailsFound.getId().intValue());
 	}
}
