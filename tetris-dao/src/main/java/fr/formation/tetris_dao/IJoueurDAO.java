package fr.formation.tetris_dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.utilisateur.Joueur;

public interface IJoueurDAO extends JpaRepository<Joueur, Integer>{

	@Query("from Joueur j where j.login = :login and j.password = :password")
	public Joueur auth(@Param("login") String login, @Param("password") String password);
	
}
