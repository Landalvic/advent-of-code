package annees.annee2015.jour02;

import java.util.stream.Stream;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour2Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour2Exercice1().lancer("src/main/resources/annee2015/jour02/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> stream = FileUtils.streamOfLines(input);
		int total = stream.mapToInt(string -> {
			String[] dimensions = string.split("x");
			int longueur = Integer.valueOf(dimensions[0]);
			int largeur = Integer.valueOf(dimensions[1]);
			int hauteur = Integer.valueOf(dimensions[2]);

			int dim1 = longueur * largeur;
			int dim2 = hauteur * largeur;
			int dim3 = longueur * hauteur;
			int surplus = Math.min(Math.min(dim1, dim2), dim3);

			return 2 * (dim1 + dim2 + dim3) + surplus;
		}).sum();
		return String.valueOf(total);
	}

}
