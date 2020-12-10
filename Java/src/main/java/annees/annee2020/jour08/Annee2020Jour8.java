package annees.annee2020.jour08;

import java.util.Arrays;

import commun.structure.ExerciceInputToObject;
import commun.util.FileUtils;

public abstract class Annee2020Jour8 extends ExerciceInputToObject<Tache> {

	@Override
	protected void init() {
	}

	@Override
	protected Tache ligneToObject(String ligne) {
		return FileUtils.transformerPattern(ligne, Arrays.asList(Accumulateur.class, NoOperation.class, Jump.class));
	}

}
