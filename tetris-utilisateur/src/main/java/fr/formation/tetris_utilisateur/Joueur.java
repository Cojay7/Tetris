package fr.formation.tetris_utilisateur;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import fr.formation.tetris_partie.Partie;


@Entity
@Table(name = "joueur")
@PrimaryKeyJoinColumn(name = "JOU_ID", referencedColumnName = "UTI_ID")
public class Joueur extends Utilisateur {

	@OneToMany(mappedBy = "joueur")
	private List<Partie> parties;
	
	
	@Override
	public String toString() {
		return "Joueur [id = " + getId() + " - login = " + getLogin() + ", getPassword()=" + getPassword() +"]";
	}

	
	
	
	
}
