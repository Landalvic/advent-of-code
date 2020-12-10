package annees.annee2018.jour05;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2018Jour5Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2018Jour5Exercice1().lancer("src/main/resources/annee2018/jour05/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		StringBuilder polymere = new StringBuilder(FileUtils.firstLine(input));
		for (int i = 0; i < polymere.length() - 1; i++) {
			if (StringUtils.equalsIgnoreCase(String.valueOf(polymere.charAt(i)), String.valueOf(polymere.charAt(i + 1)))
					&& !StringUtils.equals(String.valueOf(polymere.charAt(i)), String.valueOf(polymere.charAt(i + 1)))) {
				polymere.deleteCharAt(i + 1);
				polymere.deleteCharAt(i);
				i = i - 2;
				if (i < 0) {
					i = -1;
				}
			}
		}
		return String.valueOf(polymere.length());
	}

}
