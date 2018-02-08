package fr.formation.tetris_model_faq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "faq")
public class Faq {

	@Id
	@Column(name = "FAQ_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "La rédaction de la question est obligatoire")
	@Column(name = "FAQ_QUESTION", columnDefinition = "VARCHAR(1000)")
	private String question;
	@NotEmpty(message = "La rédaction de la réponse est obligatoire")
	@Column(name = "FAQ_REPONSE", columnDefinition = "VARCHAR(1500)")
	private String reponse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReponse() {
		return reponse;
	}

	
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

}
