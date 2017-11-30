package dz.clinic.dialyse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consomable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
	
	String ref;
	
	String descr;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="consomable",fetch=FetchType.LAZY)
	List<Caracteristique> caracts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public List<Caracteristique> getCaracts() {
		return caracts;
	}

	public void setCaracts(List<Caracteristique> caracts) {
		this.caracts = caracts;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
}
