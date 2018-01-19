package fr.formation.tetris_utilisateur;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "joueur")
@PrimaryKeyJoinColumn(name = "JOU_ID", referencedColumnName = "UTI_ID")
public class Joueur extends Utilisateur {

	
	
	
	
}
