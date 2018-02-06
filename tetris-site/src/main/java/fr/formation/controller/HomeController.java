package fr.formation.controller;

import javax.validation.Valid;

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

import fr.formation.utilisateur.Utilisateur;

@Controller
@RequestMapping("/home")
public class HomeController {

	// M�thode pour lui mapper deux param�tres en entr�e
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "home";
	}

	@PostMapping("/connect")
	public String editProduit(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult result,
			@RequestParam("id") int idUser, Model model) {
		utilisateur.setId(idUser);
		if (result.hasErrors()) {
			return "home";
		}

		return "redirect:./";
	}
}
