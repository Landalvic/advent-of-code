package annees.annee2020.jour06;

import java.util.List;

import commun.structure.ExerciceInputBlocToObject;
import commun.util.TexteUtils;

public abstract class Annee2020Jour6 extends ExerciceInputBlocToObject<Groupe> {

	protected Annee2020Jour6(int exercice) {
		super(2020, 6, exercice);
	}

	@Override
	protected Groupe blocToObject(List<String> blocs) {
		var groupe = new Groupe();
		for (String string : blocs) {
			groupe.getInfosPersonnes().add(TexteUtils.stringToSet(string));
		}
		return groupe;
	}

}
