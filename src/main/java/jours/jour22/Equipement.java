package jours.jour22;

import java.util.ArrayList;
import java.util.List;

public enum Equipement {

	RIEN(1, 2), TORCHE(0, 2), MATERIEL_ESCALADE(0, 1);

	private List<Integer> risquesAcceptes;

	private Equipement(int... risques) {
		risquesAcceptes = new ArrayList<>();
		for (int i : risques) {
			risquesAcceptes.add(i);
		}
	}

	public List<Integer> getRisquesAcceptes() {
		return risquesAcceptes;
	}

}
