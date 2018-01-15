package fr.formation.tetris;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import fr.formation.tetris_dao.tetrimino.dao.TetriminoDAO;

/**
 * LE MAIN DE OUF
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		System.out.println("Hello World!");

		// testConn();
		testListe();
		// testInsert();

	}

	static void testConn() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(
				fr.formation.tetris_dao.config.ConfigSpring.class);
		// Environment myEnvironment = myContext.getBean(Environment.class);

		TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
		t.findById(1);
		System.out.println(t);
		myContext.close();
	}

	static void testListe() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(
				fr.formation.tetris_dao.config.ConfigSpring.class);
		TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
		System.out.println(t.getAll().toString());
		myContext.close();
	}
	
	static void testInsert() throws SQLException {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(
				fr.formation.tetris_dao.config.ConfigSpring.class);
		TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
		
		t.insterTetrimino(4, "Flantier", "jaune");
	}

}
