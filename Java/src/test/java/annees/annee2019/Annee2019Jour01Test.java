package annees.annee2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2019.jour01.Annee2019Jour1Exercice1;
import annees.annee2019.jour01.Annee2019Jour1Exercice2;

class Annee2019Jour01Test {

	@Test
	void exercice1() {
		assertEquals("3471229", new Annee2019Jour1Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("5203967", new Annee2019Jour1Exercice2().lancer());
	}

}
