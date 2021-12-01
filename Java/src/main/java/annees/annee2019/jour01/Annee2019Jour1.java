package annees.annee2019.jour01;

import commun.structure.Exercice;

public abstract class Annee2019Jour1 extends Exercice {

	protected Annee2019Jour1(int exercice) {
		super(2019, 1, exercice);
	}

	@Override
	protected void init() {}

	protected int calculEssence(int masse) {
		return ((int) (masse / 3.0)) - 2;
	}

}
