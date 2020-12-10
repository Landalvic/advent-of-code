package annees.annee2020.jour08;

import commun.annotation.PatternClass;

@PatternClass("^jmp (.*)$")
public class Jump extends Tache {

	@Override
	public void run(Donnees donnees) {
		donnees.setIndex(donnees.getIndex() + getNbr());
	}

}
