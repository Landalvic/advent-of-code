package annees.annee2020.jour02;

import commun.structure.ExerciceInputToObject;
import commun.util.FileUtils;

public abstract class Annee2020Jour2 extends ExerciceInputToObject<Password> {

	@Override
	protected void init() {
	}

	@Override
	protected Password ligneToObject(String ligne) {
		return FileUtils.transformerPattern(ligne, Password.class);
	}

}
