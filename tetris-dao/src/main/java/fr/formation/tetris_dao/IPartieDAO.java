package fr.formation.tetris_dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.partie.Partie;

public interface IPartieDAO extends JpaRepository<Partie, Integer>{

}
