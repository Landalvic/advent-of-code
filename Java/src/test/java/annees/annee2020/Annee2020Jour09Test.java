package annees.annee2020;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2020.jour09.Annee2020Jour9Exercice1;
import annees.annee2020.jour09.Annee2020Jour9Exercice2;

class Annee2020Jour09Test {

	@Test
	void exercice1() {
		assertEquals("22406676", new Annee2020Jour9Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("2942387", new Annee2020Jour9Exercice2().lancer());
	}

}
