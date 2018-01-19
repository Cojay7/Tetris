package fr.formation.utilisateur;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "ADM_ID", referencedColumnName = "UTI_ID")
public class Admin extends Utilisateur {

	
	
	
	
	@Override
	public String toString() {
		return "Admin [id = " + getId() + " - login = " + getLogin() + ", getPassword()=" + getPassword() +"]";
	}
	
}
