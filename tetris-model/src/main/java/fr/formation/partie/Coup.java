package fr.formation.partie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.formation.tetrimino.Tetrimino;
import fr.formation.utilisateur.Joueur;


@Entity
@Table(name = "coup")
public class Coup {

	@Id
	@Column(name = "COU_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "COU_TETRIMINO_ID")
	private Tetrimino tetrimino;
	
	@ManyToOne
	@JoinColumn(name = "COU_JOUEUR_ID")
	private Joueur joueur;
	
	@ManyToOne
	@JoinColumn(name = "COU_PARTIE_ID")
	private Partie partie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tetrimino getTetrimino() {
		return tetrimino;
	}

	public void setTetrimino(Tetrimino tetrimino) {
		this.tetrimino = tetrimino;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

}
