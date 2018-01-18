package fr.formation.tetris_dao;

import fr.formation.tetrimino_model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDAOTetrimino extends JpaRepository<Tetrimino, Integer>{

	

}
