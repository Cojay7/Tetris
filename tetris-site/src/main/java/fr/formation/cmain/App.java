package fr.formation.cmain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.tetrimino.Tetrimino;
import fr.formation.tetris_dao.ITetriminoDAO;
import fr.formation.tetris_dao.config.ConfigSpring;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testRota();
	}

	
	static void testRota() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
		ITetriminoDAO tdao = myContext.getBean(ITetriminoDAO.class);

		Tetrimino t1 = new Tetrimino();
		t1.setForme_1rota("0,0,0,0/0,1,1,0/0,1,1,0/0,0,0,0");

		t1.setForme_2rota(t1.rotation(t1.getForme_1rota()));
		t1.setForme_3rota(t1.rotation(t1.getForme_2rota()));
		t1.setForme_4rota(t1.rotation(t1.getForme_3rota()));

		tdao.save(t1);

	}
}
