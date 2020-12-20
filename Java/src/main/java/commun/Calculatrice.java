package commun;

import java.util.List;

import commun.calculatrice.ListeBlocs;
import commun.calculatrice.Operateur;

public class Calculatrice {

	private List<Operateur> operateurs;

	public Calculatrice(List<Operateur> operateurs) {
		super();
		this.operateurs = operateurs;
	}

	public double calcul(String input) {
		return new ListeBlocs(input.replace(" ", ""), operateurs).valeur();
	}

	public List<Operateur> getOperateurs() {
		return operateurs;
	}

	public void setOperateurs(List<Operateur> operateurs) {
		this.operateurs = operateurs;
	}

}
