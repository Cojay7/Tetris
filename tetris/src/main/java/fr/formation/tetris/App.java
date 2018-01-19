package fr.formation.tetris;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import fr.formation.tetris_utilisateur.*;
import fr.formation.tetrimino_model.Tetrimino;
import fr.formation.tetris_dao.*;
import fr.formation.tetris_dao.config.*;

/**
 * LE MAIN DE OUF
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		System.out.println("Hello World!");

		// testConn();
		// testUti();
		testTetri();
		// testInsert();

	}

	// static void testConn() {
	// AnnotationConfigApplicationContext myContext = new
	// AnnotationConfigApplicationContext(
	// fr.formation.tetris_dao.config.ConfigSpring.class);
	// // Environment myEnvironment = myContext.getBean(Environment.class);
	//
	// TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
	// t.findById(1);
	// System.out.println(t);
	// myContext.close();
	// }
	//
	// static void testListe() {
	// AnnotationConfigApplicationContext myContext = new
	// AnnotationConfigApplicationContext(
	// fr.formation.tetris_dao.config.ConfigSpring.class);
	// TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
	// System.out.println(t.getAll().toString());
	// myContext.close();
	// }
	//
	// static void testInsert() throws SQLException {
	// AnnotationConfigApplicationContext myContext = new
	// AnnotationConfigApplicationContext(
	// fr.formation.tetris_dao.config.ConfigSpring.class);
	// TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
	//
	// t.insterTetrimino(4, "Flantier", "jaune");
	// }
	//
	// static void testDelete() throws SQLException {
	// AnnotationConfigApplicationContext myContext = new
	// AnnotationConfigApplicationContext(
	// ConfigSpring.class);
	// TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
	//
	// t.delete(4);
	// }

	static void testUti() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
		IJoueurDAO jdao = myContext.getBean(IJoueurDAO.class);

		Joueur j1 = new Joueur();
		j1.setLogin("Corentin");
		j1.setPassword("jayer");
		jdao.save(j1);

	}

	static void testTetri() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
		ITetriminoDAO tdao = myContext.getBean(ITetriminoDAO.class);

		Tetrimino t1 = new Tetrimino();
		t1.setCouleur("rose");
		t1.setNom("carre");
		tdao.save(t1);
	}
}
