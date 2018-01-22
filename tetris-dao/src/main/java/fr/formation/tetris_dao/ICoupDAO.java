package fr.formation.tetris_dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.partie.Coup;
import fr.formation.partie.Partie;

public interface ICoupDAO  extends JpaRepository<Coup, Integer> {

	public List<Coup> findByPartie(Partie partie);
	
	@Query("from Coup left join fetch c.joueur")
	public List<Coup> findAll();
}
