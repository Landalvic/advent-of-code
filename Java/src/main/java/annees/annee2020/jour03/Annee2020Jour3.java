package annees.annee2020.jour03;

import java.util.ArrayList;
import java.util.List;

import commun.structure.ExerciceInputToObject;
import commun.util.TexteUtils;

public abstract class Annee2020Jour3 extends ExerciceInputToObject<List<Boolean>> {

	protected Annee2020Jour3(int exercice) {
		super(2020, 3, exercice);
	}

	@Override
	protected List<Boolean> ligneToObject(String ligne) {
		List<Boolean> ligneBoolean = new ArrayList<>(ligne.length());
		for (int j = 0; j < ligne.length(); j++) {
			ligneBoolean.add(!TexteUtils.charEquals(ligne.charAt(j), "."));
		}
		return ligneBoolean;
	}

}
