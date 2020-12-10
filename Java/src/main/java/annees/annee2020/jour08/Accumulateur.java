package annees.annee2020.jour08;

import commun.annotation.PatternClass;

@PatternClass("^acc (.*)$")
public class Accumulateur extends Tache {

	@Override
	public void run(Donnees donnees) {
		donnees.setAccumulateur(donnees.getAccumulateur() + getNbr());
		donnees.setIndex(donnees.getIndex() + 1);
	}

}
