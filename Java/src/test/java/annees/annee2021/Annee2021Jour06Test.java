package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour06.Annee2021Jour6Exercice1;
import annees.annee2021.jour06.Annee2021Jour6Exercice2;

class Annee2021Jour06Test {

	@Test
	void exercice1() {
		assertEquals("387413", new Annee2021Jour6Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("1738377086345", new Annee2021Jour6Exercice2().lancer());
	}

}
