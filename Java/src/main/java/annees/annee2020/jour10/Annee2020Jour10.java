package annees.annee2020.jour10;

import java.util.Arrays;

import annees.annee2020.jour08.Accumulateur;
import annees.annee2020.jour08.Jump;
import annees.annee2020.jour08.NoOperation;
import annees.annee2020.jour08.Tache;
import commun.structure.ExerciceInputToObject;
import commun.util.FileUtils;

public abstract class Annee2020Jour10 extends ExerciceInputToObject<Tache> {

	@Override
	protected void init() {
	}

	@Override
	protected Tache ligneToObject(String ligne) {
		return FileUtils.transformerPattern(ligne, Arrays.asList(Accumulateur.class, NoOperation.class, Jump.class));
	}

}
