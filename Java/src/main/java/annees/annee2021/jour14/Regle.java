package annees.annee2021.jour14;

import java.util.ArrayList;
import java.util.List;

import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;

@PatternClass("^(.*) -> (.*)$")
public class Regle {

	@PatternAttribute(1)
	private String paire;

	@PatternAttribute(2)
	private String insertion;

	private List<Regle> regles = new ArrayList<>();

	public String getPaire() {
		return paire;
	}

	public void setPaire(String paire) {
		this.paire = paire;
	}

	public String getInsertion() {
		return insertion;
	}

	public void setInsertion(String insertion) {
		this.insertion = insertion;
	}

	public List<Regle> getRegles() {
		return regles;
	}

	public void setRegles(List<Regle> regles) {
		this.regles = regles;
	}

	@Override
	public String toString() {
		return "Regle [paire=" + paire + ", insertion=" + insertion + "]";
	}

}
