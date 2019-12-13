package annees.annee2019.jour13;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour13Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour13Exercice1().lancer("src/main/resources/annee2019/jour13/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		int nbrBloc = 0;
		while (!code.isFini()) {
			var liste = code.lancer(3);
			if (code.isFini()) {
				break;
			}
			try {

				if (liste.get(2).intValue() == 2) {
					nbrBloc++;
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println(code);
			}
		}

		return "" + nbrBloc;
	}

}
