package fr.formation.tetrimino_model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Pieces
 *
 */

import java.io.Serializable;

@Entity
@Table(name = "tetrimino")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tetrimino implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TET_ID")
	private int id;

	@Column(name = "TET_NOM")
	private String nom;

	@Column(name = "TET_COULEUR")
	private String couleur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Tetrimino [id = " + id + " - nom = " + nom + " - couleur = " + couleur + "]";
	}

}
