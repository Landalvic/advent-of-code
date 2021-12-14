package annees.annee2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2019.jour06.Annee2019Jour6Exercice1;
import annees.annee2019.jour06.Annee2019Jour6Exercice2;

class Annee2019Jour06Test {

	@Test
	void exercice1() {
		assertEquals("295834", new Annee2019Jour6Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("361", new Annee2019Jour6Exercice2().lancer());
	}

}
