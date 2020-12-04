package annees.annee2020.jour03;

import java.util.ArrayList;
import java.util.List;

import commun.AdventOfCodeException;

public class Annee2020Jour3Exercice2 extends Annee2020Jour3 {

	public static void main(String[] args) {
		new Annee2020Jour3Exercice2().lancer(2020, 3, 2, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		boolean[][] map = genererMap(input);
		List<Long> totaux = new ArrayList<>();
		for (int k = 0; k < 5; k++) {
			long total = 0;
			for (int i = 1; i * (k / 4 + 1) < map.length; i++) {
				if (map[i * (k / 4 + 1)][(i * ((2 * k + 1) % 8)) % map[0].length]) {
					total++;
				}
			}
			totaux.add(total);
		}
		return String.valueOf(totaux.stream().reduce((a, b) -> a * b).orElseThrow());
	}

}
