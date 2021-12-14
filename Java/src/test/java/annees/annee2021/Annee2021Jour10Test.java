package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour10.Annee2021Jour10Exercice1;
import annees.annee2021.jour10.Annee2021Jour10Exercice2;

class Annee2021Jour10Test {

	@Test
	void exercice1() {
		assertEquals("271245", new Annee2021Jour10Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("1685293086", new Annee2021Jour10Exercice2().lancer());
	}

}
