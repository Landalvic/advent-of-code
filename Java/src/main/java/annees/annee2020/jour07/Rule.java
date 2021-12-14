package annees.annee2020.jour07;

import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;

@PatternClass("^(.*) bags contain (.*).$")
public class Rule {

	@PatternAttribute(1)
	private String conteneur;
	@PatternAttribute(2)
	private String contenu;

	public String getConteneur() {
		return conteneur;
	}

	public void setConteneur(String conteneur) {
		this.conteneur = conteneur;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return "Rule [conteneur=" + conteneur + ", contenu=" + contenu + "]";
	}

}
