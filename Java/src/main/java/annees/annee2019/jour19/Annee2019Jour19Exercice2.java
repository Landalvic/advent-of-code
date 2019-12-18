package annees.annee2019.jour19;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour19Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour19Exercice2().lancer("src/main/resources/annee2019/jour19/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		while (!code.isFini()) {
			Long retour = code.lancer();
		}
		return "";
	}

}
