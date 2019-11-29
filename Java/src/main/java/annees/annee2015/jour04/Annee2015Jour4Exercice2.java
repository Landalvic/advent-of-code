package annees.annee2015.jour04;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;

public class Annee2015Jour4Exercice2 extends Annee2015Jour4 {

	public static void main(String[] args) {
		new Annee2015Jour4Exercice2().lancer("ckczppom");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		int i = 0;
		try {
			while (!StringUtils.equals(digest(input + i).substring(0, 6), "000000")) {
				i++;
			}
		} catch (Exception e) {
			throw new AdventOfCodeException(e.getMessage(), e);
		}
		return String.valueOf(i);
	}

}
