package annees.annee2019.jour08;

import java.util.ArrayList;
import java.util.List;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour8Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour8Exercice1().lancer("src/main/resources/annee2019/jour08/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		int wide = 25;
		int tall = 6;
		List<List<Integer>> pixels = new ArrayList<>();
		for (int i = 0; i < ligne.length();) {
			List<Integer> couche = new ArrayList<>();
			for (int j = 0; j < tall; j++) {
				for (int k = 0; k < wide; k++) {
					couche.add(Integer.parseInt("" + ligne.charAt(i)));
					i++;
				}
			}
			pixels.add(couche);
		}
		System.out.println(pixels);
		List<Integer> fewest = null;
		int min = 999999;
		for (List<Integer> list : pixels) {
			var count = list.stream().filter(i -> i == 0).count();
			System.out.println(count);
			if (min > count) {
				min = (int) count;
				fewest = list;
			}
		}
		long nbr1 = fewest.stream().filter(i -> i == 1).count();
		long nbr2 = fewest.stream().filter(i -> i == 2).count();
		System.out.println(fewest.stream().filter(i -> i == 0).count());
		System.out.println(nbr1);
		System.out.println(nbr2);
		System.out.println(nbr1 * nbr2);
		return "";
	}

}
