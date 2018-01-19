package fr.formation.tetris_dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.partie.Coup;

public interface ICoupDAO  extends JpaRepository<Coup, Integer> {

}
