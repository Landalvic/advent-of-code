package annees.annee2021.jour09;

import commun.MapCases;
import commun.Position;
import commun.SimpleCase;
import commun.structure.ExerciceInputToMap;

public abstract class Annee2021Jour9 extends ExerciceInputToMap<SimpleCase<Integer>> {

	protected Annee2021Jour9(int exercice) {
		super(2021, 9, exercice);
	}

	@Override
	protected SimpleCase<Integer> ligneToMap(MapCases<SimpleCase<Integer>> map, String charAt, Position position) {
		SimpleCase<Integer> hauteur = new SimpleCase<>(map, position, Integer.valueOf(charAt));
		if (hauteur.getId() == 9) {
			hauteur.setMur(true);
		}
		return hauteur;
	}

}
