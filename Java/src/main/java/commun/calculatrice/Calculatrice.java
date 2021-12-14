package commun.calculatrice;

import java.util.List;

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
