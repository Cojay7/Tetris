package fr.formation.tetris_dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.partie.Partie;
import fr.formation.utilisateur.Joueur;
import fr.formation.utilisateur.Utilisateur;

public interface IUtilisateurDAO extends JpaRepository<Utilisateur, Integer>{
	
//	@Query("from Joueur j where j.login = :login and j.password = :password")
//	public Joueur auth(@Param("login") String login, @Param("password") String password);
	
	//Pour reconnaitre si un utilisateur est un administrateur
//	@Query("from Utilisateur u left join fetch u.admin a where u.id = :id")
//	public Utilisateur findAdmin(@Param("id") int id);
}
