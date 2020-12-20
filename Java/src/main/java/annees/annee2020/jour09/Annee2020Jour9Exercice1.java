package annees.annee2020.jour09;

import java.util.List;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour9Exercice1 extends Annee2020Jour9 {

	public static void main(String[] args) {
		new Annee2020Jour9Exercice1().lancer(true);
	}

	public Annee2020Jour9Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Long> liste = FileUtils.listOfLongs(input);
		int pas = test ? 5 : 25;
		for (int i = pas; i < liste.size(); i++) {
			if (!trouverCorrespondance(liste, i, pas)) {
				return String.valueOf(liste.get(i));
			}
		}
		throw new AdventOfCodeException("Aucune réponse trouvée.");
	}

	private boolean trouverCorrespondance(List<Long> liste, int index, int pas) {
		for (int j = index - pas; j < index; j++) {
			for (int k = index - pas; k < index; k++) {
				if (k != j && liste.get(k) + liste.get(j) == liste.get(index)) {
					return true;
				}
			}
		}
		return false;
	}

}
