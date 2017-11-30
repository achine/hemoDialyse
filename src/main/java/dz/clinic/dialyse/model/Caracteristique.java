package dz.clinic.dialyse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Caracteristique {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
	
	int longueur;
	
	int largeur;
	
	int hauteur;
	
	
	@ManyToOne
	Consomable consomable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public Consomable getConsomable() {
		return consomable;
	}

	public void setConsomable(Consomable consomable) {
		this.consomable = consomable;
	}
	
}
