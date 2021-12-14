package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour01.Annee2021Jour1Exercice1;
import annees.annee2021.jour01.Annee2021Jour1Exercice2;

class Annee2021Jour01Test {

	@Test
	void exercice1() {
		assertEquals("1139", new Annee2021Jour1Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("1103", new Annee2021Jour1Exercice2().lancer());
	}

}
