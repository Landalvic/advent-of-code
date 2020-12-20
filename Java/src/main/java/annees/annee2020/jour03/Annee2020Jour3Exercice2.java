package annees.annee2020.jour03;

import java.util.ArrayList;
import java.util.List;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour3Exercice2 extends Annee2020Jour3 {

	public static void main(String[] args) {
		new Annee2020Jour3Exercice2().lancer(true);
	}

	public Annee2020Jour3Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<List<Boolean>> map = inputToListObject(input);
		List<Long> totaux = new ArrayList<>();
		for (int k = 0; k < 5; k++) {
			long total = 0;
			for (int i = 1; i * (k / 4 + 1) < map.size(); i++) {
				int ligne = i * (k / 4 + 1);
				int colonne = (i * ((2 * k + 1) % 8));
				if (map.get(ligne).get(colonne % map.get(ligne).size()).booleanValue()) {
					total++;
				}
			}
			totaux.add(total);
		}
		return String.valueOf(totaux.stream().reduce((a, b) -> a * b).orElseThrow());
	}

}
