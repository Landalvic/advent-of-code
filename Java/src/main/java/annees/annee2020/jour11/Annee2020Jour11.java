package annees.annee2020.jour11;

import annees.annee2020.jour08.Tache;
import commun.Map;
import commun.structure.ExerciceInputToObject;

public abstract class Annee2020Jour11 extends ExerciceInputToObject<Tache> {

	protected Map<Siege> map;

	@Override
	protected void init() {
		map = new Map<>();
	}

	@Override
	protected Tache ligneToObject(String ligne) {
		return null;
	}

}
