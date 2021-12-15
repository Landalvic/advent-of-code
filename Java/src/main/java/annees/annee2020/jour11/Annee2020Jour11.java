package annees.annee2020.jour11;

import commun.MapModifiable;
import commun.Position;
import commun.structure.AdventOfCodeException;
import commun.structure.ExerciceInputToMap;

public abstract class Annee2020Jour11 extends ExerciceInputToMap<Siege> {

	public Annee2020Jour11(int exercice) {
		super(2020, 11, exercice);
	}

	@Override
	protected void init() {}

	protected abstract void gererSiege(Siege siege);

	@Override
	public String run(String input) throws AdventOfCodeException {
		MapModifiable<Siege> map = inputToMap(input);
		boolean auMoinsUnChangement;
		do {
			map.streamAllCase().forEach(this::gererSiege);
			auMoinsUnChangement = map.streamAllCase().filter(siege -> {
				if (siege.getOccupe() != null && siege.getFuturePlace() != null
						&& !siege.getFuturePlace().equals(siege.getOccupe())) {
					siege.setOccupe(siege.getFuturePlace());
					return true;
				} else {
					return false;
				}
			}).count() > 0;
		} while (auMoinsUnChangement);
		return String.valueOf(map.streamAllCase().filter(siege -> siege.getOccupe() != null && siege.getOccupe()).count());
	}

	@Override
	protected Siege ligneToMap(MapModifiable<Siege> map, String charAt, int posY, int posX) {
		switch (charAt) {
			case "L":
				return new Siege(map, new Position(posX, posY), false);
			case "#":
				return new Siege(map, new Position(posX, posY), true);
			case ".":
				return new Siege(map, new Position(posX, posY), null);
			default:
				return null;
		}
	}

}
