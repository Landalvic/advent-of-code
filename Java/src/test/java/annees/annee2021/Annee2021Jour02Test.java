package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour02.Annee2021Jour2Exercice1;
import annees.annee2021.jour02.Annee2021Jour2Exercice2;

class Annee2021Jour02Test {

	@Test
	void exercice1() {
		assertEquals("1989014", new Annee2021Jour2Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("2006917119", new Annee2021Jour2Exercice2().lancer());
	}

}
