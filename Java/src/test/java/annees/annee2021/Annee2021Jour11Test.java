package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour11.Annee2021Jour11Exercice1;
import annees.annee2021.jour11.Annee2021Jour11Exercice2;

class Annee2021Jour11Test {

	@Test
	void exercice1() {
		assertEquals("1599", new Annee2021Jour11Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("418", new Annee2021Jour11Exercice2().lancer());
	}

}
