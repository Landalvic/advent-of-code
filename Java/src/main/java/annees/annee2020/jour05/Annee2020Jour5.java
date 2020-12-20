package annees.annee2020.jour05;

import commun.structure.ExerciceInputToObject;

public abstract class Annee2020Jour5 extends ExerciceInputToObject<Integer> {

	public Annee2020Jour5(int exercice) {
		super(2020, 5, exercice);
	}

	@Override
	protected void init() {}

	@Override
	protected Integer ligneToObject(String ligne) {
		int min = 0;
		int max = 128;
		int minS = 0;
		int maxS = 8;
		for (int i = 0; i < ligne.length(); i++) {
			String c = String.valueOf(ligne.charAt(i));
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
			}
		}
		return (max - 1) * 8 + (maxS - 1);
	}

}
