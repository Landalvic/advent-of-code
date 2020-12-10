package annees.annee2020.jour06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Groupe {

	private List<Set<String>> infosPersonnes;

	public Groupe() {
		super();
		this.infosPersonnes = new ArrayList<>();
	}

	public void ajouterInfos(String ligne) {
		Set<String> cha = new HashSet<>();
		for (int i = 0; i < ligne.length(); i++) {
			cha.add(String.valueOf(ligne.charAt(i)));
		}
		infosPersonnes.add(cha);
	}

	public List<Set<String>> getInfosPersonnes() {
		return infosPersonnes;
	}

	public void setInfosPersonnes(List<Set<String>> infosPersonnes) {
		this.infosPersonnes = infosPersonnes;
	}

}
