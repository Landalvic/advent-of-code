package annees.annee2015.jour05;

import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2015Jour5Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour5Exercice1().lancer("src/main/resources/annee2015/jour05/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> stream = FileUtils.streamOfLines(input);
		long total = stream.filter(string -> {
			int nbrVoyelle = 0;
			boolean doubleLettre = false;
			boolean condition3 = true;
			for (int i = 0; i < string.length(); i++) {
				String strChar = String.valueOf(string.charAt(i));
				if (StringUtils.equals(strChar, "a") || StringUtils.equals(strChar, "e") || StringUtils.equals(strChar, "i")
						|| StringUtils.equals(strChar, "o") || StringUtils.equals(strChar, "u")) {
					nbrVoyelle++;
				}
				if (i >= 1) {
					char voyellePrec = string.charAt(i - 1);
					String chaine = "" + voyellePrec + string.charAt(i);
					if (voyellePrec == string.charAt(i)) {
						doubleLettre = true;
					}
					if (StringUtils.equals(chaine, "ab") || StringUtils.equals(chaine, "cd") || StringUtils.equals(chaine, "pq")
							|| StringUtils.equals(chaine, "xy")) {
						condition3 = false;
					}
				}
			}
			return nbrVoyelle >= 3 && doubleLettre && condition3;
		}).count();
		return String.valueOf(total);
	}

}
