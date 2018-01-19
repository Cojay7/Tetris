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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	@ManyToOne
	@JoinColumn(name = "PAR_JOUEUR_ID")
	private Joueur joueur;
}
