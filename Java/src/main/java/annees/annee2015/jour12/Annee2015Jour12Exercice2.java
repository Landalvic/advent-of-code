package annees.annee2015.jour12;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2015Jour12Exercice2 extends Annee2015Jour12 {

	public static void main(String[] args) {
		new Annee2015Jour12Exercice2().lancer("src/main/resources/annee2015/jour12/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		StringBuilder string = new StringBuilder(FileUtils.firstLine(input));

		int indexRouge = string.indexOf(":\"red\"");
		while (indexRouge != -1) {
			int decalageAccolade = 0;
			for (int i = indexRouge; i < string.length(); i++) {
				if (StringUtils.equals(String.valueOf(string.charAt(i)), "}")) {
					if (decalageAccolade == 0) {
						int indexDebut = 0;
						for (int j = indexRouge; j >= 0; j--) {
							if (StringUtils.equals(String.valueOf(string.charAt(j)), "{")) {
								if (decalageAccolade == 0) {
									indexDebut = j;
									break;
								} else {
									decalageAccolade--;
								}
							} else if (StringUtils.equals(String.valueOf(string.charAt(j)), "}")) {
								decalageAccolade++;
							}
						}
						string = new StringBuilder(string.substring(0, indexDebut) + string.substring(i + 1));
						break;
					} else {
						decalageAccolade--;
					}
				} else if (StringUtils.equals(String.valueOf(string.charAt(i)), "{")) {
					decalageAccolade++;
				}
			}
			indexRouge = string.indexOf(":\"red\"");
		}
		try {
			return calcul(string);
		} catch (Exception e) {
			throw new AdventOfCodeException(e.getMessage(), e);
		}
	}

}
