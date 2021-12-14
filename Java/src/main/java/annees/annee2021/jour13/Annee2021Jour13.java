package annees.annee2021.jour13;

import java.util.Arrays;

import commun.structure.ExerciceInputToObject;
import commun.util.TexteUtils;

public abstract class Annee2021Jour13 extends ExerciceInputToObject<Input> {

	protected Annee2021Jour13(int exercice) {
		super(2021, 13, exercice);
	}

	@Override
	protected Input ligneToObject(String ligne) {
		return TexteUtils.transformerPattern(ligne, Arrays.asList(Point.class, Pliage.class));
	}

}
