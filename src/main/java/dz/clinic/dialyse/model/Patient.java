package dz.clinic.dialyse.model;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;

@Entity
public class Patient {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
	String name;
	
	LocalDate date;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="patient",fetch=FetchType.LAZY) 
	
	List<DetailsPatient> details;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<DetailsPatient> getDetails() {
		return details;
	}
	public void setDetails(List<DetailsPatient> details) {
		this.details = details;
	}
	
	
}
