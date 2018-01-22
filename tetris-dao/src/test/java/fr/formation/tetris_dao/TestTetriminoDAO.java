package fr.formation.tetris_dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.formation.tetrimino.Tetrimino;
import fr.formation.tetris_dao.config.ConfigSpring;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfigSpring.class })
public class TestTetriminoDAO {
	@BeforeClass
	public static void lancement() {
		System.out.println("Test de l'existence des DAO...");
	}

	@Autowired
	private ITetriminoDAO itdao;

	@Test
	public void testDAO() {
		assertNotNull(itdao);

	}

	@Test
	@Transactional
	@Rollback(true)
	public void testModifierTetri() {
		Optional<Tetrimino> t = itdao.findById(1);
		Tetrimino myTetri;
		assertTrue(t.isPresent());
		myTetri = t.get();
		assertNotNull(myTetri);
		myTetri.setCouleur("rouge clair");
		itdao.save(myTetri);
		assertEquals("rouge clair", itdao.findById(1).get().getCouleur());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteTetri() {
		try {
			itdao.deleteById(1);
			assertFalse(itdao.findById(1).isPresent());
		} catch (Exception e) {
			fail("N'a pas pu supprimer");

		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAjouterTetri() {
		Tetrimino t = new Tetrimino();

	}
}
