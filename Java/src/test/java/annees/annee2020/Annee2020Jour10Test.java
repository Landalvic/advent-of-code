package annees.annee2020;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2020.jour10.Annee2020Jour10Exercice1;
import annees.annee2020.jour10.Annee2020Jour10Exercice2;

class Annee2020Jour10Test {

	@Test
	void exercice1() {
		assertEquals("1656", new Annee2020Jour10Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("56693912375296", new Annee2020Jour10Exercice2().lancer());
	}

}
