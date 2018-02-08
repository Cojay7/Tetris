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

import fr.formation.exception.FaqValidationException;
import fr.formation.tetris_dao.IFaqDAO;
import fr.formation.tetris_model_faq.Faq;
import fr.formation.utilisateur.Utilisateur;

@Controller
@RequestMapping("/faq")
public class FAQController {

	@Autowired
	private IFaqDAO daoF;
	
	@GetMapping("")
	public String liste(Model model) {
		model.addAttribute("faqs", daoF.findAll());
		return "faq";
	}	
	
	@GetMapping("/add")
	public String addFaq(Model model) {
		model.addAttribute("faq", new Faq());
		return "addfaq";
	}

	@PostMapping("/add")
	public String saveFaq(@Valid @ModelAttribute("faq") Faq faq, BindingResult result,
			 Model model) {
		if (result.hasErrors()) {
			return "addfaq";
		}
		daoF.save(faq);
		return "redirect:./";
	}
	
	@GetMapping("/edit")
	public String getFaq(@RequestParam("id") int idFaq, Model model) {
		model.addAttribute("faq",daoF.findById(idFaq).get()); 
		return "addfaq";
	}
	
	@PostMapping("/edit")
	public String editFaq(@Valid @ModelAttribute("faq") Faq faq, BindingResult result,
			@RequestParam("id") int idFaq, Model model) {
		faq.setId(idFaq);
	
		if (result.hasErrors()) {
			return "addfaq";
		}

		daoF.save(faq);
		return "redirect:./";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int idFaq) {
		daoF.deleteById(idFaq);
		return "redirect:./";

	}
	
}
