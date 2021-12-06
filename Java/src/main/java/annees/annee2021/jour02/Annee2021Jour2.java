package annees.annee2021.jour02;

import commun.structure.ExerciceInputToObject;
import commun.util.TexteUtils;

public abstract class Annee2021Jour2 extends ExerciceInputToObject<Commande> {

	protected Annee2021Jour2(int exercice) {
		super(2021, 2, exercice);
	}

	@Override
	protected Commande ligneToObject(String ligne) {
		return TexteUtils.transformerPattern(ligne, Commande.class);
	}

}
