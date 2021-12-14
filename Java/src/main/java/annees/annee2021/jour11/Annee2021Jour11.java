package annees.annee2021.jour11;

import commun.MapCases;
import commun.Position;
import commun.structure.ExerciceInputToMap;

public abstract class Annee2021Jour11 extends ExerciceInputToMap<Pieuvre> {

	protected Annee2021Jour11(int exercice) {
		super(2021, 11, exercice);
	}

	@Override
	protected Pieuvre ligneToMap(MapCases<Pieuvre> map, String charAt, Position position) {
		return new Pieuvre(map, position, Integer.valueOf(charAt));
	}

}
