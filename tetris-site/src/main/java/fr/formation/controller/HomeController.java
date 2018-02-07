package fr.formation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.tetris_dao.IUtilisateurDAO;
import fr.formation.utilisateur.Utilisateur;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private IUtilisateurDAO daoUtilisateur;

	@GetMapping(value = "")
	public String home() {

		return "home";
	}

	@PostMapping("")
	public String connect(@Valid @ModelAttribute("login") Utilisateur login, BindingResult result,
			@Valid @ModelAttribute("password") String password, BindingResult result2, Model model) {

		if (result.hasErrors() || result2.hasErrors()) {
			return "home";
		}

		return "connect";
	}

	@GetMapping(value = "/connect")
	public String connect(Model model) {
		model.addAttribute("logins", daoUtilisateur.findAll());

		return "connect";
	}
}
