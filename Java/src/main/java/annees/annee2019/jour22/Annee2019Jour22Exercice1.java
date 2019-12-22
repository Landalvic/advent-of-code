package annees.annee2019.jour22;

import java.util.regex.Pattern;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour22Exercice1 extends Exercice {

	protected static final Pattern pattern1 = Pattern.compile("deal with increment (.*)");
	protected static final Pattern pattern2 = Pattern.compile("deal into new stack");
	protected static final Pattern pattern3 = Pattern.compile("cut (.*)");

	public static void main(String[] args) {
		new Annee2019Jour22Exercice1().lancer("src/main/resources/annee2019/jour22/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		int taille = 10007;
		int[] cartes = new int[taille];
		for (int i = 0; i < cartes.length; i++) {
			cartes[i] = i;
		}
		for (String string : lignes) {
			int[] newCartes = new int[taille];
			var matcher = FileUtils.trouverPatternInt(string, pattern1, 1);
			var matcher2 = FileUtils.trouverPattern(string, pattern2, 0);
			var matcher3 = FileUtils.trouverPatternInt(string, pattern3, 1);
			if (matcher != null) {
				int increment = matcher[0];
				for (int i = 0; i < newCartes.length; i++) {
					newCartes[(i * increment) % cartes.length] = cartes[i];
				}
			} else if (matcher2 != null) {
				for (int i = 0; i < newCartes.length; i++) {
					newCartes[i] = cartes[cartes.length - 1 - i];
				}
			} else if (matcher3 != null) {
				int cut = matcher3[0];
				if (cut < 0) {
					cut += cartes.length;
				}
				for (int i = 0; i < newCartes.length; i++) {
					newCartes[i] = cartes[(i + cut) % cartes.length];
				}
			}
			cartes = newCartes;
		}
		int position = 0;
		for (int i : cartes) {
			System.out.print(i);
			if (i == 2019) {
				break;
			}
			position++;
		}
		return "" + position;
	}

}
