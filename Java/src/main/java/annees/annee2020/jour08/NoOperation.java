package annees.annee2020.jour08;

import commun.annotation.PatternClass;

@PatternClass("^nop (.*)$")
public class NoOperation extends Tache {

	@Override
	public void run(Donnees donnees) {
		donnees.setIndex(donnees.getIndex() + 1);
	}

}
