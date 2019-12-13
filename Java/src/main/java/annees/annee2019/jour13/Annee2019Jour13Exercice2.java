package annees.annee2019.jour13;

import java.util.ArrayList;
import java.util.List;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour13Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour13Exercice2().lancer("src/main/resources/annee2019/jour13/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);

		long[][] map = new long[24][42];

		code.getBlocs()[0] = "2";
		long score = 0;
		List<Long> inputs = new ArrayList<>();
		while (!code.isFini()) {
			var liste = code.lancer(3, inputs);
			if (code.isFini()) {
				break;
			}
			if (liste.get(0).intValue() == -1) {
				score = liste.get(2).intValue();
			} else {
				map[liste.get(1).intValue()][liste.get(0).intValue()] = liste.get(2).longValue();
			}

			int paddle = position(map, 3);
			int ball = position(map, 4);
			if (paddle != -1 && ball != -1) {
				inputs.clear();
				long joystick = 0;
				if (ball > paddle) {
					joystick = 1;
				} else if (ball < paddle) {
					joystick = -1;
				}
				inputs.add(joystick);
			}
		}
		afficherMap(map);

		return "" + score;
	}

	private void afficherMap(long[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private int position(long[][] map, long numero) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == numero) {
					return j;
				}
			}
		}
		return -1;
	}

}
