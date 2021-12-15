package annees.annee2021.jour15;

import commun.Direction;
import commun.InterfaceMap;
import commun.Position;
import commun.SimpleCase;
import commun.structure.ExerciceInputToMap;

public abstract class Annee2021Jour15 extends ExerciceInputToMap<SimpleCase<CheminMoinsRisque>> {

	protected Annee2021Jour15(int exercice) {
		super(2021, 15, exercice);
	}

	@Override
	protected SimpleCase<CheminMoinsRisque> ligneToMap(InterfaceMap<SimpleCase<CheminMoinsRisque>> map, String charAt, Position position) {
		return new SimpleCase<>(map, position, new CheminMoinsRisque(Integer.parseInt(charAt)));
	}

	protected String runOnMap(InterfaceMap<SimpleCase<CheminMoinsRisque>> map) {
		var arrivee = map.getCase(map.maxX(), map.maxY());
		map.getCase(0, 0).getId().setLongueur(0L);
		while (map.anyMatch(v -> !v.getId().isDejaTravaille())) {
			map.forEach(c -> {
				if (c.getId().getLongueur() != null) {
					if (c.getPosition().equals(arrivee.getPosition())) {
						c.getId().setDejaTravaille(true);
					} else if (!c.getId().isDejaTravaille()) {
						c.getId().setDejaTravaille(true);
						travaillerPositionAutour(c.getId(), map, c.getPosition().voisin(Direction.DROITE));
						travaillerPositionAutour(c.getId(), map, c.getPosition().voisin(Direction.BAS));
						travaillerPositionAutour(c.getId(), map, c.getPosition().voisin(Direction.HAUT));
						travaillerPositionAutour(c.getId(), map, c.getPosition().voisin(Direction.GAUCHE));
					}
				}
			});
		}
		return String.valueOf(map.getCase(map.maxX(), map.maxY()).getId().getLongueur());
	}

	protected void travaillerPositionAutour(CheminMoinsRisque entry, InterfaceMap<SimpleCase<CheminMoinsRisque>> map,
			Position position) {
		var c = map.getCase(position);
		if (c != null) {
			var comparaison = map.getCase(position);
			var ajoutLongueur = c.getId().getNumero();
			if (comparaison.getId().getLongueur() == null || comparaison.getId().getLongueur() > entry.getLongueur() + ajoutLongueur) {
				comparaison.getId().setDejaTravaille(false);
				comparaison.getId().setLongueur(entry.getLongueur() + ajoutLongueur);
			}
		}
	}

}
