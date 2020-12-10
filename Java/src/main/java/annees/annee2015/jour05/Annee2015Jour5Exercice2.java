package annees.annee2015.jour05;

import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2015Jour5Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour5Exercice2().lancer("src/main/resources/annee2015/jour05/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> stream = FileUtils.streamOfLines(input);
		long total = stream.filter(string -> {
			boolean doubleLettre = false;
			boolean conditionPair = false;
			for (int i = 0; i < string.length(); i++) {
				if (i >= 1 && !conditionPair) {
					char voyellePrec1 = string.charAt(i - 1);
					String chaine = "" + voyellePrec1 + string.charAt(i);
					for (int j = 0; j < string.length() - 1; j++) {
						String chaine2 = "" + string.charAt(j) + string.charAt(j + 1);
						if (StringUtils.equals(chaine, chaine2) && i != j && i != (j + 1) && i != (j + 2)) {
							conditionPair = true;
						}
					}
				}
				if (i >= 2) {
					char voyellePrec2 = string.charAt(i - 2);
					if (voyellePrec2 == string.charAt(i)) {
						doubleLettre = true;
					}
				}
			}
			return conditionPair && doubleLettre;
		}).count();
		return String.valueOf(total);
	}

}
