package fr.formation.tetrimino_model;

/**
 * Pieces
 *
 */
public class ModelTetrimino {

	private int id;
	private String nom;
	private String couleur;

	public ModelTetrimino() {

	}

	public ModelTetrimino(int id, String nom, String couleur) {
		this.id = id;
		this.nom = nom;
		this.couleur = couleur;
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
		return "ModelTetrimino [id=" + id + ", nom=" + nom + ", couleur=" + couleur + "]";
	}

}
