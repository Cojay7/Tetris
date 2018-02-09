package fr.formation.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.tetrimino.Tetrimino;
import fr.formation.tetris_dao.ITetriminoDAO;

@Controller
@RequestMapping("/tetrimino")
public class TetriminoController {

	@Autowired
	private ITetriminoDAO daoTetri;

	@GetMapping("")
	public String liste(Model model, Tetrimino tetrimino) {
		model.addAttribute("tetriminos", daoTetri.findAll());
		return "tetrimino";
	}

	// A ajouter si on veut que l'administrateur modifie les tailles des tetriminos
	// @GetMapping("/taille")
	// public String tailleTetri(Model model) {
	// model.addAttribute("tetrimino", new Tetrimino());
	// return "tailltetrimino";
	// }

	// , @RequestParam int taille
	// model.addAttribute("taille", taille);
	@GetMapping("/add")
	public String addTetri(Model model) {
		model.addAttribute("tetrimino", new Tetrimino());
		return "addtetrimino";
	}

	@PostMapping("/add")
	public String saveTetri(@Valid @ModelAttribute("tetrimino") Tetrimino tetrimino, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addtetrimino";
		}
		String res = "";
		int x = 4;
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= x; j++) {
				if (request.getParameter(i + "." + j) == null) {
					res += "0,";
				} else
					res += "1,";

			}
			res += "/";
		}
		tetrimino.setForme_1rota(res);
//		tetrimino.setForme_2rota(tetrimino.rotation(tetrimino.getForme_1rota()));
//		tetrimino.setForme_3rota(tetrimino.rotation(tetrimino.getForme_2rota()));
//		tetrimino.setForme_4rota(tetrimino.rotation(tetrimino.getForme_3rota()));

		daoTetri.save(tetrimino);
		return "tetrimino";
	}

	@GetMapping("/edit")
	public String getTetri(@RequestParam("id") int idTetrimino, @ModelAttribute("tetrimino") Tetrimino tetrimino,
			Model model, HttpServletRequest request) {

		String res = "";
		model.addAttribute("tetrimino", daoTetri.findById(idTetrimino).get());
		tetrimino.getCouleur();
		Tetrimino tetri = daoTetri.findById(idTetrimino).get();
		String test = tetri.getForme_1rota();
		String[] tab = test.split("/");
		String[][] matrice = new String[tab.length][tab.length];

		for (int i = 0; i < tab.length; i++) {
			matrice[i] = tab[i].split(",");
		}

		model.addAttribute("matrice", matrice);

		return "addtetrimino";
	}

	@PostMapping("/edit")
	public String editTetri(@Valid @ModelAttribute("tetrimino") Tetrimino tetrimino, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addtetrimino";
		}
		String res = "";
		int x = 4;
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= x; j++) {
				if (request.getParameter(i + "." + j) == null) {
					res += "0" + ",";
				} else {
					res += "1" + ",";
				}
			}
			res += "/";
		}
		tetrimino.setForme_1rota(res);
		tetrimino.setForme_2rota(tetrimino.rotation(tetrimino.getForme_1rota()));
		tetrimino.setForme_3rota(tetrimino.rotation(tetrimino.getForme_2rota()));
		tetrimino.setForme_4rota(tetrimino.rotation(tetrimino.getForme_3rota()));
		daoTetri.save(tetrimino);
		return "redirect:./";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int idTetrimino) {
		daoTetri.deleteById(idTetrimino);
		return "redirect:./";

	}

}
