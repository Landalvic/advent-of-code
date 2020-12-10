package annees.annee2020.jour06;

import commun.structure.ExerciceInputToObject;

public abstract class Annee2020Jour6 extends ExerciceInputToObject<Groupe> {

	protected Groupe groupes;

	@Override
	protected void init() {
		groupes = new Groupe();
	}

	@Override
	protected Groupe ligneToObject(String ligne) {
		if (ligne.trim().length() == 0) {
			var p = groupes;
			groupes = new Groupe();
			return p;
		} else {
			groupes.ajouterInfos(ligne);
			return null;
		}
	}

}
