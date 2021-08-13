package fr.formation.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "habitation")
@PrimaryKeyJoinColumn(name="HAB_ID", referencedColumnName="BAT_ID")
public class Habitation extends Batiment {
	@Column(name = "HAB_LOYER", nullable = false)
	private BigDecimal loyer;
	
	@OneToMany(mappedBy = "habitation")
	private List<Citoyen> habitants;

	public void ajouterHabitant(Citoyen nvHabitant) {
		int nbHab = habitants.size();
		if(nbHab < nbPlace) {
			habitants.add(nvHabitant);
			nvHabitant.setHabitation(this);
		}
		else
			System.out.println("Habitation pleine ! Pas d'ajout d'habitant");
	}
	
	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public BigDecimal getLoyer() {
		return loyer;
	}

	public void setLoyer(BigDecimal loyer) {
		this.loyer = loyer;
	}

	public List<Citoyen> getHabitants() {
		return habitants;
	}

	public void setHabitants(List<Citoyen> habitants) {
		this.habitants = habitants;
	}

	public Habitation() {
	}

	public Habitation(String nom, BigDecimal superficie, BigDecimal prix, BigDecimal coutEntretien, int nbPlace, BigDecimal loyer) {
		super(nom, superficie, prix, coutEntretien, nbPlace);
		this.loyer = loyer;
	}

}
