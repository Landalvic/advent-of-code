package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour05.Annee2021Jour5Exercice1;
import annees.annee2021.jour05.Annee2021Jour5Exercice2;

class Annee2021Jour05Test {

	@Test
	void exercice1() {
		assertEquals("5585", new Annee2021Jour5Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("17193", new Annee2021Jour5Exercice2().lancer());
	}

}
