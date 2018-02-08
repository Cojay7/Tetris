package fr.formation.controller;

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

	@GetMapping("/taille")
	public String tailleTetri(Model model) {
		model.addAttribute("tetrimino", new Tetrimino());
		return "tailltetrimino";
	}
	
//	@PostMapping("/taille")
//	public String saveTailleTetri(Model model) {
//		model.addAttribute("tetrimino", new Tetrimino());
//		return "addtetrimino";
//	}
	
	@GetMapping("/add")
	public String addTetri(Model model,  @RequestParam int taille) {
		model.addAttribute("taille", taille);
		model.addAttribute("tetrimino", new Tetrimino());
		return "addtetrimino";
	}

	@PostMapping("/add")
	public String saveTetri(@Valid @ModelAttribute("tetrimino") Tetrimino tetrimino, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "addtetrimino";
		}
		daoTetri.save(tetrimino);
		return "redirect:./";
	}

	@GetMapping("/edit")
	public String getFaq(@RequestParam("id") int idTetrimino, Model model) {
		model.addAttribute("tetrimino", daoTetri.findById(idTetrimino).get());
		return "addtetrimino";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int idTetrimino) {
		daoTetri.deleteById(idTetrimino);
		return "redirect:./";

	}

}
