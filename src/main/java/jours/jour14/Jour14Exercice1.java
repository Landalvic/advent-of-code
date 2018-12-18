package jours.jour14;

import java.util.ArrayList;
import java.util.List;

public class Jour14Exercice1 {

	public static void main(String[] args) {

		int input = 509671;

		int indexElfe1 = 0;
		int indexElfe2 = 1;
		List<Integer> recettes = new ArrayList<>(input + 15);
		recettes.add(3);
		recettes.add(7);

		while (recettes.size() < input + 10) {
			int recette1 = recettes.get(indexElfe1);
			int recette2 = recettes.get(indexElfe2);
			String melange = "" + (recette1 + recette2);
			for (int j = 0; j < melange.length(); j++) {
				recettes.add(Integer.valueOf("" + melange.charAt(j)));
			}
			indexElfe1 = (indexElfe1 + 1 + recette1) % recettes.size();
			indexElfe2 = (indexElfe2 + 1 + recette2) % recettes.size();
		}

		StringBuilder resultat = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			resultat.append(recettes.get(input + i));
		}
		System.out.println(resultat);

	}

}
