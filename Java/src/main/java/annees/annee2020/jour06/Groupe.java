package annees.annee2020.jour06;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Groupe {

	private List<Set<String>> infosPersonnes;

	public Groupe() {
		super();
		this.infosPersonnes = new ArrayList<>();
	}

	public List<Set<String>> getInfosPersonnes() {
		return infosPersonnes;
	}

	public void setInfosPersonnes(List<Set<String>> infosPersonnes) {
		this.infosPersonnes = infosPersonnes;
	}

	@Override
	public String toString() {
		return "Groupe [infosPersonnes=" + infosPersonnes + "]";
	}

}
