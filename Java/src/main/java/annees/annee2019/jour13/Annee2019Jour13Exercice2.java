package annees.annee2019.jour13;

import commun.AdventOfCodeException;
import commun.Map;
import commun.Position;

public class Annee2019Jour13Exercice2 extends Annee2019Jour13 {

	public static void main(String[] args) {
		new Annee2019Jour13Exercice2().lancer(2019, 13, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var code = inputToCode(input);
		code.getBlocs()[0] = "2";
		Map<Bloc> map = new Map<>();
		long score = 0;
		Long inputPaddle = null;
		while (!code.isFini()) {
			var liste = code.lancer(3, inputPaddle);
			if (liste.size() == 3) {
				if (liste.get(0).intValue() == -1) {
					score = liste.get(2).intValue();
				} else {
					map.setCase(new Bloc(map, new Position(liste.get(0).intValue(), liste.get(1).intValue()), liste.get(2).longValue()));
				}
				Bloc paddle = map.find(c -> c.getValeur() == 3);
				Bloc ball = map.find(c -> c.getValeur() == 4);
				if (paddle != null && ball != null) {
					inputPaddle = (long) Double.compare(ball.getPosition().getX(), paddle.getPosition().getX());
				}
			}
		}
		return String.valueOf(score);
	}

}
