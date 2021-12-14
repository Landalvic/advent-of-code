package annees.annee2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2019.jour02.Annee2019Jour2Exercice1;
import annees.annee2019.jour02.Annee2019Jour2Exercice2;

class Annee2019Jour02Test {

	@Test
	void exercice1() {
		assertEquals("2842648", new Annee2019Jour2Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("9074", new Annee2019Jour2Exercice2().lancer());
	}

}
