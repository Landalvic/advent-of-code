package annees.annee2020.jour05;

import commun.structure.ExerciceInputToObject;
import commun.util.TexteUtils;

public abstract class Annee2020Jour5 extends ExerciceInputToObject<Integer> {

	protected Annee2020Jour5(int exercice) {
		super(2020, 5, exercice);
	}

	@Override
	protected Integer ligneToObject(String ligne) {
		int min = 0;
		int max = 128;
		int minS = 0;
		int maxS = 8;
		var listeCaracteres = TexteUtils.stringToList(ligne);
		for (String c : listeCaracteres) {
			switch (c) {
				case "F":
					max -= (max - min) / 2;
					break;
				case "B":
					min += (max - min) / 2;
					break;
				case "L":
					maxS -= (maxS - minS) / 2;
					break;
				case "R":
					minS += (maxS - minS) / 2;
					break;
				default:
					break;
			}
		}
		return (max - 1) * 8 + (maxS - 1);
	}

}
