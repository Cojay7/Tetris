package fr.formation.tetris_partie;
import fr.formation.tetris_utilisateur.Joueur;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="partie")
public class Partie {

	@Id
	@Column(name = "PAR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "PAR_DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "JOU_ID")
	private Joueur joueur;
}
