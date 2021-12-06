package annees.annee2021;

import annees.annee2021.jour01.Annee2021Jour1Exercice1;
import annees.annee2021.jour01.Annee2021Jour1Exercice2;
import annees.annee2021.jour02.Annee2021Jour2Exercice1;
import annees.annee2021.jour02.Annee2021Jour2Exercice2;
import annees.annee2021.jour03.Annee2021Jour3Exercice1;
import annees.annee2021.jour03.Annee2021Jour3Exercice2;
import commun.structure.Annee;

public class Annee2021 extends Annee {

	public static void main(String[] args) {
		new Annee2021().lancer();
	}

	public Annee2021() {
		super();
		exercices.add(new Annee2021Jour1Exercice1());
		exercices.add(new Annee2021Jour1Exercice2());
		exercices.add(new Annee2021Jour2Exercice1());
		exercices.add(new Annee2021Jour2Exercice2());
		exercices.add(new Annee2021Jour3Exercice1());
		exercices.add(new Annee2021Jour3Exercice2());
	}

}
