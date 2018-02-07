package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.tetris_dao.ITetriminoDAO;



@Controller
@RequestMapping("/tetrimino")
public class TetriminoController {
	
	@Autowired
	private ITetriminoDAO daoTetri;
	
	@GetMapping("")
	public String liste(Model model) {
		model.addAttribute("tetriminos", daoTetri.findAll());
		return "tetrimino";
	}	
	
	

}
