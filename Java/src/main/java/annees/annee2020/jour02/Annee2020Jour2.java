package annees.annee2020.jour02;

import commun.structure.ExerciceInputToObject;
import commun.util.TexteUtils;

public abstract class Annee2020Jour2 extends ExerciceInputToObject<Password> {

	public Annee2020Jour2(int exercice) {
		super(2020, 2, exercice);
	}

	@Override
	protected void init() {}

	@Override
	protected Password ligneToObject(String ligne) {
		return TexteUtils.transformerPattern(ligne, Password.class);
	}

}
