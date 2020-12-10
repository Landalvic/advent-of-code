package annees.annee2019.jour13;

import commun.structure.AdventOfCodeException;

public class Annee2019Jour13Exercice1 extends Annee2019Jour13 {

	public static void main(String[] args) {
		new Annee2019Jour13Exercice1().lancer(2019, 13, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var code = inputToCode(input);
		int nbrBloc = 0;
		while (!code.isFini()) {
			var liste = code.lancer(3);
			if (liste.size() == 3 && liste.get(2).intValue() == 2) {
				nbrBloc++;
			}
		}
		return String.valueOf(nbrBloc);
	}

}
