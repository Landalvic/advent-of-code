package annees.annee2020.jour14;

import java.util.regex.Pattern;

import commun.structure.Exercice;

public abstract class Annee2020Jour14 extends Exercice {

	protected Pattern pattern;

	public Annee2020Jour14(int exercice) {
		super(2020, 14, exercice);
	}

	@Override
	protected void init() {
		pattern = Pattern.compile("mem\\[(.*)\\] = (.*)");
	}

}
