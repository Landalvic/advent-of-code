package annees.annee2019.jour22;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour22Exercice3 extends Exercice {

	protected static final Pattern pattern1 = Pattern.compile("deal with increment (.*)");
	protected static final Pattern pattern2 = Pattern.compile("deal into new stack");
	protected static final Pattern pattern3 = Pattern.compile("cut (.*)");

	public static void main(String[] args) {
		new Annee2019Jour22Exercice3().lancer("src/main/resources/annee2019/jour22/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		long taille = 100;
		long monNombre = 16;
		List<Operation> operations = new ArrayList<Operation>();
		for (String string : lignes) {
			var matcher = FileUtils.trouverPatternInt(string, pattern1, 1);
			var matcher2 = FileUtils.trouverPattern(string, pattern2, 0);
			var matcher3 = FileUtils.trouverPatternInt(string, pattern3, 1);
			if (matcher.length > 0) {
				int increment = matcher[0];
				operations.add(new Increment(increment));
			} else if (matcher2.length > 0) {
				operations.add(new NewStack());
			} else if (matcher3.length > 0) {
				int cut = matcher3[0];
				if (cut < 0) {
					cut += taille;
				}
				operations.add(new Cut(cut));
			}
		}
		for (int i = 0; i < 20; i++) {
			monNombre = operations.get(operations.size() - 1).calcul(operations, operations.size() - 1, taille,
					monNombre);
			System.out.println(monNombre);

		}
		return "";
	}

}
