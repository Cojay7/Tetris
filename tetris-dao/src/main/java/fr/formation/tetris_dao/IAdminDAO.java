package fr.formation.tetris_dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.utilisateur.Admin;

public interface IAdminDAO extends JpaRepository<Admin, Integer>{

	@Query("from Admin a where a.login = :login and a.password = :password")
	public Admin auth(@Param("login") String login, @Param("password") String password);
	
}
