package annees.annee2020;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2020.jour06.Annee2020Jour6Exercice1;
import annees.annee2020.jour06.Annee2020Jour6Exercice2;

class Annee2020Jour06Test {

	@Test
	void exercice1() {
		assertEquals("6549", new Annee2020Jour6Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("3466", new Annee2020Jour6Exercice2().lancer());
	}

}
