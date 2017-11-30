package dz.clinic.dialyse;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import dz.clinic.dialyse.model.Caracteristique;
import dz.clinic.dialyse.model.Consomable;
import dz.clinic.dialyse.services.ConsomableService;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Sql(scripts={"classpath:cleandbConso.sql","classpath:dataConso.sql"})
public class TestConsomableService {

	@Autowired
	ConsomableService consomableService;
	
	@Test
	public void testChercherConsomablesEtCaracts() {
		
		List<Consomable> liste = consomableService.chercherConsomablesEtCaracts(0L);
		
		Assert.assertEquals(1, liste.size());
		
		Assert.assertEquals(1, liste.get(0).getCaracts().size());
		Caracteristique caractsFound = liste.get(0).getCaracts().get(0);
		
		Assert.assertEquals(20, caractsFound.getHauteur());
		
	}

}
