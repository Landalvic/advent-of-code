package annees.annee2015.jour04;

import org.apache.commons.lang3.StringUtils;

public class Annee2015Jour4Exercice1 extends Annee2015Jour4 {

	public static void main(String[] args) {
		new Annee2015Jour4Exercice1().lancer("ckczppom");
	}

	@Override
	public String run(String input) throws Exception {
		int i = 0;
		while (!StringUtils.equals(digest(input + i).substring(0, 5), "00000")) {
			i++;
		}
		return String.valueOf(i);
	}

}
