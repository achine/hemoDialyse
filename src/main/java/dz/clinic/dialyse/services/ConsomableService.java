package dz.clinic.dialyse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.clinic.dialyse.ConsomableRepository;
import dz.clinic.dialyse.model.Consomable;

@Service
public class ConsomableService {

	@Autowired ConsomableRepository consomableRepository;
	
	
	public List<Consomable> chercherConsomablesEtCaracts(Long id) {
		
		return consomableRepository.chercherConsomablesEtCaracts(id);
	}
}
