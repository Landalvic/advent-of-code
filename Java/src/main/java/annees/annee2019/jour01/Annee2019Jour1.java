package annees.annee2019.jour01;

import commun.Exercice;

public abstract class Annee2019Jour1 extends Exercice {

	protected int calculEssence(int masse) {
		return ((int) (masse / 3.0)) - 2;
	}

}
