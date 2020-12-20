package annees.annee2020;

import annees.annee2020.jour01.Annee2020Jour1Exercice1;
import annees.annee2020.jour01.Annee2020Jour1Exercice2;
import annees.annee2020.jour02.Annee2020Jour2Exercice1;
import annees.annee2020.jour02.Annee2020Jour2Exercice2;
import annees.annee2020.jour03.Annee2020Jour3Exercice1;
import annees.annee2020.jour03.Annee2020Jour3Exercice2;
import annees.annee2020.jour04.Annee2020Jour4Exercice1;
import annees.annee2020.jour04.Annee2020Jour4Exercice2;
import annees.annee2020.jour05.Annee2020Jour5Exercice1;
import annees.annee2020.jour05.Annee2020Jour5Exercice2;
import annees.annee2020.jour06.Annee2020Jour6Exercice1;
import annees.annee2020.jour06.Annee2020Jour6Exercice2;
import annees.annee2020.jour07.Annee2020Jour7Exercice1;
import annees.annee2020.jour07.Annee2020Jour7Exercice2;
import annees.annee2020.jour08.Annee2020Jour8Exercice1;
import annees.annee2020.jour08.Annee2020Jour8Exercice2;
import annees.annee2020.jour09.Annee2020Jour9Exercice1;
import annees.annee2020.jour09.Annee2020Jour9Exercice2;
import annees.annee2020.jour10.Annee2020Jour10Exercice1;
import annees.annee2020.jour10.Annee2020Jour10Exercice2;
import annees.annee2020.jour11.Annee2020Jour11Exercice1;
import annees.annee2020.jour11.Annee2020Jour11Exercice2;
import annees.annee2020.jour12.Annee2020Jour12Exercice1;
import annees.annee2020.jour12.Annee2020Jour12Exercice2;
import annees.annee2020.jour13.Annee2020Jour13Exercice1;
import annees.annee2020.jour13.Annee2020Jour13Exercice2;
import annees.annee2020.jour14.Annee2020Jour14Exercice1;
import annees.annee2020.jour14.Annee2020Jour14Exercice2;
import annees.annee2020.jour15.Annee2020Jour15Exercice1;
import annees.annee2020.jour15.Annee2020Jour15Exercice2;
import annees.annee2020.jour16.Annee2020Jour16Exercice1;
import annees.annee2020.jour16.Annee2020Jour16Exercice2;
import commun.structure.Annee;

public class Annee2020 extends Annee {

	public Annee2020() {
		super();
		exercices.add(new Annee2020Jour1Exercice1());
		exercices.add(new Annee2020Jour1Exercice2());
		exercices.add(new Annee2020Jour2Exercice1());
		exercices.add(new Annee2020Jour2Exercice2());
		exercices.add(new Annee2020Jour3Exercice1());
		exercices.add(new Annee2020Jour3Exercice2());
		exercices.add(new Annee2020Jour4Exercice1());
		exercices.add(new Annee2020Jour4Exercice2());
		exercices.add(new Annee2020Jour5Exercice1());
		exercices.add(new Annee2020Jour5Exercice2());
		exercices.add(new Annee2020Jour6Exercice1());
		exercices.add(new Annee2020Jour6Exercice2());
		exercices.add(new Annee2020Jour7Exercice1());
		exercices.add(new Annee2020Jour7Exercice2());
		exercices.add(new Annee2020Jour8Exercice1());
		exercices.add(new Annee2020Jour8Exercice2());
		exercices.add(new Annee2020Jour9Exercice1());
		exercices.add(new Annee2020Jour9Exercice2());
		exercices.add(new Annee2020Jour10Exercice1());
		exercices.add(new Annee2020Jour10Exercice2());
		exercices.add(new Annee2020Jour11Exercice1());
		exercices.add(new Annee2020Jour11Exercice2());
		exercices.add(new Annee2020Jour12Exercice1());
		exercices.add(new Annee2020Jour12Exercice2());
		exercices.add(new Annee2020Jour13Exercice1());
		exercices.add(new Annee2020Jour13Exercice2());
		exercices.add(new Annee2020Jour14Exercice1());
		exercices.add(new Annee2020Jour14Exercice2());
		exercices.add(new Annee2020Jour15Exercice1());
		exercices.add(new Annee2020Jour15Exercice2());
		exercices.add(new Annee2020Jour16Exercice1());
		exercices.add(new Annee2020Jour16Exercice2());
	}

	public static void main(String[] args) {
		new Annee2020().lancer();
	}

}
