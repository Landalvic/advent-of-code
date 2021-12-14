package annees.annee2020;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2020.jour01.Annee2020Jour1Exercice1;
import annees.annee2020.jour01.Annee2020Jour1Exercice2;

class Annee2020Jour01Test {

	@Test
	void exercice1() {
		assertEquals("658899", new Annee2020Jour1Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("155806250", new Annee2020Jour1Exercice2().lancer());
	}

}
