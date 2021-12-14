package annees.annee2020.jour08;

import java.util.Arrays;

import commun.structure.ExerciceInputToObject;
import commun.util.TexteUtils;

public abstract class Annee2020Jour8 extends ExerciceInputToObject<Tache> {

	protected Annee2020Jour8(int exercice) {
		super(2020, 8, exercice);
	}

	@Override
	protected Tache ligneToObject(String ligne) {
		return TexteUtils.transformerPattern(ligne, Arrays.asList(Accumulateur.class, NoOperation.class, Jump.class));
	}

}
