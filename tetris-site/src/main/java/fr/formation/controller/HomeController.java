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

	@GetMapping(value = { "", "/{utilisateur}" })
	public String home(@PathVariable(required = false) String utilisateur,
			@RequestParam(required = false, defaultValue = "0") int idProduit, Model model) {
		model.addAttribute("utilisateur", utilisateur);
		model.addAttribute("idProduit", idProduit);
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
