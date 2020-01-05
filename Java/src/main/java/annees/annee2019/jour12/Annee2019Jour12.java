package annees.annee2019.jour12;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import commun.AdventOfCodeException;
import commun.Exercice;
import commun.Position;
import util.FileUtils;

public abstract class Annee2019Jour12 extends Exercice {

	protected static final Pattern pattern = Pattern.compile("<x=(.*), y=(.*), z=(.*)>");

	protected List<Lune> inputToLunes(String input) throws AdventOfCodeException {
		var lignes = FileUtils.streamOfLines(input);
		return lignes.map(ligne -> {
			var matcher = FileUtils.trouverPatternInt(ligne, pattern, 3);
			return new Lune(new Position(matcher[0], matcher[1], matcher[2]));
		}).collect(Collectors.toList());
	}

	protected void tour(List<Lune> lunes) {
		for (var lune : lunes) {
			lune.calculerVitesse(lunes);
		}
		for (var lune : lunes) {
			lune.deplacer();
		}
	}

}
