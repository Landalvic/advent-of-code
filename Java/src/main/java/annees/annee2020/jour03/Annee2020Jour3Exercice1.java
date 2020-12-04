package annees.annee2020.jour03;

import commun.AdventOfCodeException;

public class Annee2020Jour3Exercice1 extends Annee2020Jour3 {

	public static void main(String[] args) {
		new Annee2020Jour3Exercice1().lancer(2020, 3, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		boolean[][] map = genererMap(input);
		int total = 0;
		for (int i = 1; i < map.length; i++) {
			if (map[i][(i * 3) % map[0].length]) {
				total++;
			}
		}
		return String.valueOf(total);
	}

}
