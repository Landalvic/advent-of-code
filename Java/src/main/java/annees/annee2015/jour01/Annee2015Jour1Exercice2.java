package annees.annee2015.jour01;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2015Jour1Exercice2 extends Annee2015Jour1 {

	public static void main(String[] args) {
		new Annee2015Jour1Exercice2().lancer(2015, 1, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		String arbre = FileUtils.firstLine(input);
		int etage = 0;
		int position = 0;
		for (int i = 0; i < arbre.length(); i++) {
			if (StringUtils.equals(String.valueOf(arbre.charAt(i)), "(")) {
				etage++;
			} else if (StringUtils.equals(String.valueOf(arbre.charAt(i)), ")")) {
				etage--;
			}
			if (etage == -1) {
				position = i + 1;
				return String.valueOf(position);
			}
		}
		return String.valueOf(position);
	}

}
