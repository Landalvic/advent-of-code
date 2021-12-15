package annees.annee2021.jour15;

import commun.InterfaceMap;
import commun.MapUnmodifiable;
import commun.Position;
import commun.SimpleCase;
import commun.structure.AdventOfCodeException;

public class Annee2021Jour15Exercice2 extends Annee2021Jour15 {

	public static void main(String[] args) {
		new Annee2021Jour15Exercice2().lancer(true);
	}

	public Annee2021Jour15Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var map = inputToMap(input, true);
		int width = (int) map.width();
		int height = (int) map.height();
		InterfaceMap<SimpleCase<CheminMoinsRisque>> bigMap = new MapUnmodifiable<>(new SimpleCase[width * 5][height * 5]);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				addBigMap(map, bigMap, width, height, i, j);
			}
		}
		return runOnMap(bigMap);
	}

	private void addBigMap(InterfaceMap<SimpleCase<CheminMoinsRisque>> map, InterfaceMap<SimpleCase<CheminMoinsRisque>> bigMap, int width, int height, int i, int j) {
		map.forEach(c -> {
			var position = new Position(c.getPosition().getX() + i * width, c.getPosition().getY() + j * height);
			var chemin = new CheminMoinsRisque(((c.getId().getNumero() + i + j - 1) % 9) + 1);
			var newC = new SimpleCase<>(bigMap, position, chemin);
			bigMap.addCase(newC);
		});
	}

}
