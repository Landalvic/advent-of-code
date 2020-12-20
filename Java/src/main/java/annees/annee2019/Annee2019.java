package annees.annee2019;

import annees.annee2019.jour01.Annee2019Jour1Exercice1;
import annees.annee2019.jour01.Annee2019Jour1Exercice2;
import annees.annee2019.jour02.Annee2019Jour2Exercice1;
import annees.annee2019.jour02.Annee2019Jour2Exercice2;
import annees.annee2019.jour03.Annee2019Jour3Exercice1;
import annees.annee2019.jour03.Annee2019Jour3Exercice2;
import annees.annee2019.jour04.Annee2019Jour4Exercice1;
import annees.annee2019.jour04.Annee2019Jour4Exercice2;
import annees.annee2019.jour05.Annee2019Jour5Exercice1;
import annees.annee2019.jour05.Annee2019Jour5Exercice2;
import commun.structure.Annee;

public class Annee2019 extends Annee {

	public Annee2019() {
		super();
		exercices.add(new Annee2019Jour1Exercice1());
		exercices.add(new Annee2019Jour1Exercice2());
		exercices.add(new Annee2019Jour2Exercice1());
		exercices.add(new Annee2019Jour2Exercice2());
		exercices.add(new Annee2019Jour3Exercice1());
		exercices.add(new Annee2019Jour3Exercice2());
		exercices.add(new Annee2019Jour4Exercice1());
		exercices.add(new Annee2019Jour4Exercice2());
		exercices.add(new Annee2019Jour5Exercice1());
		exercices.add(new Annee2019Jour5Exercice2());
	}

	public static void main(String[] args) {
		new Annee2019().lancer();
	}

}
