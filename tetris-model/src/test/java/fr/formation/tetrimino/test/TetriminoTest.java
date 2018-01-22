package fr.formation.tetrimino.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.formation.tetrimino.Tetrimino;


public class TetriminoTest  {
	
	@BeforeClass
	public static void lancement() {
		System.out.println("Test de l'existence des rotations...");
	}
	
	
	private Tetrimino tetrimino =new Tetrimino();

	@Test
	public void testTetrimino() {
		assertNotNull(tetrimino);
	}

	@Test

	public void testRotation() {
		tetrimino.setForme_1rota("0,0,0/1,1,1/0,1,0");
		tetrimino.setForme_2rota(tetrimino.rotation(tetrimino.getForme_1rota()));
		tetrimino.setForme_3rota(tetrimino.rotation(tetrimino.getForme_2rota()));
		tetrimino.setForme_4rota(tetrimino.rotation(tetrimino.getForme_3rota()));
		
		assertEquals("0,1,0,/0,1,1,/0,1,0,/",tetrimino.getForme_2rota());
		assertEquals("0,1,0,/1,1,1,/0,0,0,/",tetrimino.getForme_3rota());
		assertEquals("0,1,0,/1,1,0,/0,1,0,/",tetrimino.getForme_4rota());
	}
}
