package annees.annee2015.jour02;

import java.util.stream.Stream;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour2Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour2Exercice2().lancer("src/main/resources/annee2015/jour02/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> stream = FileUtils.streamOfLines(input);
		int total = stream.mapToInt(string -> {
			String[] dimensions = string.split("x");
			int longueur = Integer.valueOf(dimensions[0]);
			int largeur = Integer.valueOf(dimensions[1]);
			int hauteur = Integer.valueOf(dimensions[2]);

			int max = Math.max(Math.max(longueur, largeur), hauteur);
			int enveloppe = 2 * (longueur + largeur + hauteur - max);
			int arc = longueur * largeur * hauteur;

			return enveloppe + arc;
		}).sum();
		return String.valueOf(total);
	}

}
