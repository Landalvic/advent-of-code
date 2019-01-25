package annees.annee2015.jour12;

import util.FileUtils;

public class Annee2015Jour12Exercice1 extends Annee2015Jour12 {

	public static void main(String[] args) {
		new Annee2015Jour12Exercice1().lancer("src/main/resources/annee2015/jour12/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		StringBuilder string = new StringBuilder(FileUtils.firstLine(input));
		return calcul(string);
	}

}
