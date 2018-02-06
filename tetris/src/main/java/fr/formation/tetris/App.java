//package fr.formation.tetris;
//
//import java.sql.SQLException;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.core.env.Environment;
//
//import fr.formation.utilisateur.Admin;
//import fr.formation.utilisateur.Joueur;
//import fr.formation.partie.Coup;
//import fr.formation.partie.Partie;
//import fr.formation.tetrimino.Tetrimino;
//import fr.formation.tetris_dao.*;
//import fr.formation.tetris_dao.config.*;
//import fr.formation.tetris_model_faq.Faq;
//
///**
// * LE MAIN DE OUF
// *
// */
//public class App {
//	public static void main(String[] args) throws SQLException {
//		System.out.println("Hello World!");
//
//		// testConn();
//
//		// testFAQ();
//
//		Authen();
//		// testTetri();
//		// testInsert();
//		// testRota();
//
//		// testUti();
//		// testTetri();
//		// testInsert();
//		// testPartie();
//
//		// testFinal();
//		// Affiche2();
//
//	}
//
//	// static void testConn() {
//	// AnnotationConfigApplicationContext myContext = new
//	// AnnotationConfigApplicationContext(
//	// fr.formation.tetris_dao.config.ConfigSpring.class);
//	// // Environment myEnvironment = myContext.getBean(Environment.class);
//	//
//	// TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
//	// t.findById(1);
//	// System.out.println(t);
//	// myContext.close();
//	// }
//	//
//	// static void testListe() {
//	// AnnotationConfigApplicationContext myContext = new
//	// AnnotationConfigApplicationContext(
//	// fr.formation.tetris_dao.config.ConfigSpring.class);
//	// TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
//	// System.out.println(t.getAll().toString());
//	// myContext.close();
//	// }
//	//
//	// static void testInsert() throws SQLException {
//	// AnnotationConfigApplicationContext myContext = new
//	// AnnotationConfigApplicationContext(
//	// fr.formation.tetris_dao.config.ConfigSpring.class);
//	// TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
//	//
//	// t.insterTetrimino(4, "Flantier", "jaune");
//	// }
//	//
//	// static void testDelete() throws SQLException {
//	// AnnotationConfigApplicationContext myContext = new
//	// AnnotationConfigApplicationContext(
//	// ConfigSpring.class);
//	// TetriminoDAO t = myContext.getBean(TetriminoDAO.class);
//	//
//	// t.delete(4);
//	// }
//
//	static void testUti() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//		IAdminDAO adao = myContext.getBean(IAdminDAO.class);
//
//		Admin a1 = new Admin();
//		a1.setLogin("Jafar");
//		a1.setPassword("yago");
//		adao.save(a1);
//
//	}
//
//	static void testTetri() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//		ITetriminoDAO tdao = myContext.getBean(ITetriminoDAO.class);
//
//		Tetrimino t1 = new Tetrimino();
//		t1.setCouleur("bleu");
//		t1.setNom("ligne");
//		tdao.save(t1);
//	}
//
//	static void testRota() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//		ITetriminoDAO tdao = myContext.getBean(ITetriminoDAO.class);
//
//		Tetrimino t1 = tdao.findById(1).get();
//
//		t1.setNom("petit_t");
//
//		t1.setForme_1rota("0,0,0/1,1,1/0,1,0");
//
//		t1.setForme_2rota(t1.rotation(t1.getForme_1rota()));
//		t1.setForme_3rota(t1.rotation(t1.getForme_2rota()));
//		t1.setForme_4rota(t1.rotation(t1.getForme_3rota()));
//
//		tdao.save(t1);
//
//	}
//
//	static void testPartie() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//		ITetriminoDAO tdao = myContext.getBean(ITetriminoDAO.class);
//		IJoueurDAO jdao = myContext.getBean(IJoueurDAO.class);
//		IPartieDAO pdao = myContext.getBean(IPartieDAO.class);
//
//		Joueur j = jdao.findById(1).get();
//		Partie p = new Partie();
//
//		Date d1 = new Date();
//		d1.getDate();
//
//		p.setDate(d1);
//		p.setJoueur(j);
//		pdao.save(p);
//
//	}
//
//	static void testPartie2() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//		ITetriminoDAO tdao = myContext.getBean(ITetriminoDAO.class);
//		IJoueurDAO jdao = myContext.getBean(IJoueurDAO.class);
//		IPartieDAO pdao = myContext.getBean(IPartieDAO.class);
//		ICoupDAO cdao = myContext.getBean(ICoupDAO.class);
//
//		Partie p = new Partie();
//		Joueur j = jdao.findById(2).get();
//		p.setJoueur(j);
//
//		Tetrimino t1 = tdao.findById(1).get();
//		Coup coup1 = new Coup();
//		coup1.setTetrimino(t1);
//		coup1.setPartie(p);
//		cdao.save(coup1);
//
//	}
//
//	static void testPartie3() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//		ITetriminoDAO tdao = myContext.getBean(ITetriminoDAO.class);
//		IJoueurDAO jdao = myContext.getBean(IJoueurDAO.class);
//		IPartieDAO pdao = myContext.getBean(IPartieDAO.class);
//		ICoupDAO cdao = myContext.getBean(ICoupDAO.class);
//
//		Partie p = pdao.findById(2).get();
//		Joueur j = jdao.findById(2).get();
//		Coup c = cdao.findById(2).get();
//		// System.out.println(cdao.findByPartie(p));
//		// System.out.println(pdao.findByJoueur(j));
//	}
//
//	static void testAdmin() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//
//		IAdminDAO jdao = myContext.getBean(IAdminDAO.class);
//		Admin ad = new Admin();
//		ad.setLogin("Hercule");
//		ad.setPassword("disney");
//		jdao.save(ad);
//	}
//
//	static void testFAQ() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//
//		IFaqDAO fdao = myContext.getBean(IFaqDAO.class);
//		Faq f = new Faq();
//		f.setQuestion("What are the keyboard controls for this game?");
//		f.setReponse("Arrow Keys – Move the Tetrimino\n" + "Rotate Clockwise – Up Arrow\n"
//				+ "Rotate Counter–clockwise – Z\n" + "Hard Drop – Space Bar\n" + "Pause – esc");
//		fdao.save(f);
//	}
//
//	static void testFinal() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//		ITetriminoDAO tdao = myContext.getBean(ITetriminoDAO.class);
//		IJoueurDAO jdao = myContext.getBean(IJoueurDAO.class);
//		IPartieDAO pdao = myContext.getBean(IPartieDAO.class);
//		ICoupDAO cdao = myContext.getBean(ICoupDAO.class);
//
//		Partie p = pdao.findById(2).get();
//		Joueur j = jdao.findById(2).get();
//		Coup coup1 = new Coup();
//		coup1.setTetrimino(tdao.findById(1).get());
//		coup1.setPartie(p);
//		cdao.save(coup1);
//		Date d1 = new Date();
//		d1.getDate();
//		p.setDate(d1);
//		p.setJoueur(j);
//		pdao.save(p);
//
//		List<Partie> parties = pdao.findAll();
//		for (Partie p2 : parties) {
//			System.out.println(p2 + "\n");
//			System.out.println("Joueur : " + p2.getJoueur() + "\n");
//		}
//
//	}
//
//	static void Affiche() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//		IPartieDAO pdao = myContext.getBean(IPartieDAO.class);
//
//		List<Partie> parties = pdao.findAll();
//		for (Partie p : parties) {
//			System.out.println(p + "\n");
//			System.out.println("Joueur : " + p.getJoueur() + "\n");
//		}
//	}
//
//	static void Affiche2() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//		IPartieDAO pdao = myContext.getBean(IPartieDAO.class);
//		IJoueurDAO jdao = myContext.getBean(IJoueurDAO.class);
//
//		List<Partie> parties = pdao.findByJoueur(jdao.findById(2).get());
//		for (Partie p : parties) {
//			System.out.println(p + "\n");
//
//		}
//
//	}
//
//	static void Authen() {
//		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(ConfigSpring.class);
//		IAdminDAO adao = myContext.getBean(IAdminDAO.class);
//		IJoueurDAO jdao = myContext.getBean(IJoueurDAO.class);
//		
//		try {
//			if(jdao.auth("gfgrgr", "yago") != null)
//			System.out.println("Bienvenue au joueur\t" +jdao.auth("gfgrgr", "yago"));
//			else throw new Exception();
//			}
//			catch (Exception e) {
//				System.out.println("Désolé, erreur de connexion");
//			}
//		
//		try {
//			if(adao.auth("Jafar", "yago") != null)
//			System.out.println("Bienvenue à l'administrateur\t" +adao.auth("Jafar", "yago"));
//			else throw new Exception();
//			}
//			catch (Exception e) {
//				System.out.println("Désolé, erreur de connexion");
//			}
//	
//}
//}
