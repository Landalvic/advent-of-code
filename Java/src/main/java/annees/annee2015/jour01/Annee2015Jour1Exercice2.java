package annees.annee2015.jour01;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour1Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour1Exercice2().lancer("src/main/resources/annee2015/jour01/data.txt");
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
				break;
			}
		}
		return String.valueOf(position);
	}

}
