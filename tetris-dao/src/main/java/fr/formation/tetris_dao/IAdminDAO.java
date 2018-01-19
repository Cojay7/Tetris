package fr.formation.tetris_dao;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.tetris_utilisateur.*;

public interface IAdminDAO extends JpaRepository<Admin, Integer>{

}
