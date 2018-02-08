package fr.formation.tetrimino;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import java.util.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Pieces
 *
 */

import java.io.Serializable;

@Entity
@Table(name = "tetrimino")
@Inheritance(strategy = InheritanceType.JOINED)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tetrimino implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TET_ID")
	private int id;
	@NotEmpty(message = "L'attribution d'un nom est obligatoire")
	@Column(name = "TET_NOM")
	private String nom;

	@Column(name = "TET_COULEUR")
	private String couleur;
	@NotEmpty(message = "La sélection d'une forme est obligatoire")
	@Column(name = "TET_FORME_1ROTA")
	private String forme_1rota;

	@Column(name = "TET_FORME_2ROTA")
	private String forme_2rota;

	@Column(name = "TET_FORME_3ROTA")
	private String forme_3rota;

	@Column(name = "TET_FORME_4ROTA")
	private String forme_4rota;

	public String rotation(String forme_1rota) {
		String res = "";
		String[] formes = forme_1rota.split("/");
		int h = formes.length;
		String[][] matrice = new String[h][];

		for (int i = 0; i < h; i++) {
			matrice[i] = formes[i].split(",");
		}

		int l = matrice[0].length;

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < h; j++) {
				res += matrice[j][l - i - 1] + ",";
			}
			res += "/";
		}
		return res;
	}

	public String getForme_1rota() {
		return forme_1rota;
	}

	public void setForme_1rota(String forme_base) {
		this.forme_1rota = forme_base;
	}

	public String getForme_2rota() {
		return forme_2rota;
	}

	public void setForme_2rota(String forme_2rota) {
		this.forme_2rota = forme_2rota;
	}

	public String getForme_3rota() {
		return forme_3rota;
	}

	public void setForme_3rota(String forme_3rota) {
		this.forme_3rota = forme_3rota;
	}

	public String getForme_4rota() {
		return forme_4rota;
	}

	public void setForme_4rota(String forme_4rota) {
		this.forme_4rota = forme_4rota;
	}

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
