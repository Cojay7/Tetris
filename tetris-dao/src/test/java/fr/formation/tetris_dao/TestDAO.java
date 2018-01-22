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

import fr.formation.partie.Coup;
import fr.formation.partie.Partie;
import fr.formation.tetrimino.Tetrimino;
import fr.formation.tetris_dao.config.ConfigSpring;
import fr.formation.utilisateur.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfigSpring.class })
public class TestDAO {

	@BeforeClass
	public static void lancement() {
		System.out.println("Test de l'existence des DAO...");
	}

	@Autowired
	private IAdminDAO iadao;
	@Autowired
	private ICoupDAO icdao;
	@Autowired
	private IJoueurDAO ijdao;
	@Autowired
	private IPartieDAO ipdao;
	@Autowired
	private ITetriminoDAO itdao;

	@Test
	public void testDAO() {
		assertNotNull(iadao);
		assertNotNull(icdao);
		assertNotNull(ijdao);
		assertNotNull(ipdao);
		assertNotNull(itdao);

	}

	@Test
	@Transactional
	@Rollback(true)
	public void testModifierAdmin() {
		Optional<Admin> p = iadao.findById(3);
		Admin myAdmin;
		assertTrue(p.isPresent());
		myAdmin = p.get();
		assertNotNull(myAdmin);
		myAdmin.setLogin("toutafé");
		iadao.save(myAdmin);
		assertEquals("toutafé", iadao.findById(3).get().getLogin());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testModifierCoup() {
		Optional<Coup> c = icdao.findById(1);
		Coup myCoup;
		assertTrue(c.isPresent());
		myCoup = c.get();
		assertNotNull(myCoup);
		myCoup.setTetrimino(itdao.findById(2).get());
		icdao.save(myCoup);
		assertEquals(itdao.findById(2).get(), icdao.findById(1).get().getTetrimino());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testModifierJoueur() {
		Optional<Joueur> j = ijdao.findById(1);
		Joueur myJoueur;
		assertTrue(j.isPresent());
		myJoueur = j.get();
		assertNotNull(myJoueur);
		myJoueur.setLogin("toutafé");
		ijdao.save(myJoueur);
		assertEquals("toutafé", ijdao.findById(1).get().getLogin());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testModifierPartie() {
		Optional<Partie> p2 = ipdao.findById(1);
		Partie myPartie;
		assertTrue(p2.isPresent());
		myPartie = p2.get();
		assertNotNull(myPartie);
		myPartie.setJoueur(ijdao.findById(2).get());
		ipdao.save(myPartie);
		assertEquals(ijdao.findById(2).get(), ipdao.findById(1).get().getJoueur());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testModifierTetrimino() {
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
	public void testDelete() {
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
	public void testAjouter() {
		Tetrimino t = new Tetrimino();

	}
}
