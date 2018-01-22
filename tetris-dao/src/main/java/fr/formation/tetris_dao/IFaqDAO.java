package fr.formation.tetris_dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.tetris_model_faq.Faq;

public interface IFaqDAO extends JpaRepository<Faq, Integer>{

}
