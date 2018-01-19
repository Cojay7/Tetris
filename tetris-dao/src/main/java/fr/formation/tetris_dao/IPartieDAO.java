package fr.formation.tetris_dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.partie.Coup;
import fr.formation.partie.Partie;
import fr.formation.utilisateur.Joueur;

public interface IPartieDAO extends JpaRepository<Partie, Integer>{

	public List<Partie> findByJoueur(Joueur joueur);
}
