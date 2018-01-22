package fr.formation.utilisateur;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import fr.formation.partie.Partie;


@Entity
@Table(name = "joueur")
@PrimaryKeyJoinColumn(name = "JOU_ID", referencedColumnName = "UTI_ID")

public class Joueur extends Utilisateur {

	@OneToMany(mappedBy = "joueur")
	private List<Partie> parties;
	
	
	@Override
	public String toString() {
		return getLogin();
	}

	
	
	
	
}
