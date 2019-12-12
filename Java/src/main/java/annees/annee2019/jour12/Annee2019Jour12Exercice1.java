package annees.annee2019.jour12;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour12Exercice1 extends Exercice {

	protected static final Pattern pattern = Pattern.compile("<x=(.*), y=(.*), z=(.*)>");

	public static void main(String[] args) {
		new Annee2019Jour12Exercice1().lancer("src/main/resources/annee2019/jour12/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.streamOfLines(input);
		var lunes = lignes.map(ligne -> {
			var matcher = FileUtils.trouverPatternInt(ligne, pattern, 3);
			return new Lune(matcher[0], matcher[1], matcher[2]);
		}).collect(Collectors.toList());
		for (int i = 0; i < 1000; i++) {
			for (var lune : lunes) {
				lune.calculerVitesse(lunes);
			}
			for (var lune : lunes) {
				lune.deplacer();
			}
		}
		var sum = lunes.stream().mapToInt(lune -> lune.calculerEnergie()).sum();
		return "" + sum;
	}

}
