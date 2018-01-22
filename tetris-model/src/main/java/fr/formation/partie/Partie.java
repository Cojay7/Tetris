package fr.formation.partie;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import fr.formation.utilisateur.Joueur;

@Entity
@Table(name="partie")
public class Partie {

	@Override
	public String toString() {
		return "Partie [id=" + id + ", date=" + date + ", joueur=" + joueur + "]";
	}

	@Id
	@Column(name = "PAR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "PAR_DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "PAR_SCORE")
	private int score;
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

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
	
	public List<Coup> getCoups() {
		return coups;
	}

	public void setCoups(List<Coup> coups) {
		this.coups = coups;
	}

	@OneToMany(mappedBy = "partie")
	private List<Coup> coups;
	
}
