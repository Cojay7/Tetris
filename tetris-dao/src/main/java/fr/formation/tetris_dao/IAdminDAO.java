package fr.formation.tetris_dao;
import org.springframework.data.jpa.repository.JpaRepository;



import fr.formation.utilisateur.Admin;

public interface IAdminDAO extends JpaRepository<Admin, Integer>{

}
