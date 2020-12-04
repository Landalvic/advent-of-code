package annees.annee2015.jour02;

import java.util.stream.Stream;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2015Jour2Exercice2 extends Annee2015Jour2 {

	public static void main(String[] args) {
		new Annee2015Jour2Exercice2().lancer(2015, 2, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> stream = FileUtils.streamOfLines(input);
		int total = stream.mapToInt(string -> {
			String[] dimensions = string.split("x", -1);
			int longueur = Integer.parseInt(dimensions[0]);
			int largeur = Integer.parseInt(dimensions[1]);
			int hauteur = Integer.parseInt(dimensions[2]);
			int max = Math.max(Math.max(longueur, largeur), hauteur);
			int enveloppe = 2 * (longueur + largeur + hauteur - max);
			int arc = longueur * largeur * hauteur;
			return enveloppe + arc;
		}).sum();
		return String.valueOf(total);
	}

}
