package fr.formation.tetris_dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.tetrimino.Tetrimino;



public interface ITetriminoDAO extends JpaRepository<Tetrimino, Integer>{

}
