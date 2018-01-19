package fr.formation.tetris_dao;
import org.springframework.data.jpa.repository.JpaRepository;


import fr.formation.utilisateur.Joueur;

public interface IJoueurDAO extends JpaRepository<Joueur, Integer>{

}
