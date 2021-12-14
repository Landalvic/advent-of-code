package annees.annee2020;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2020.jour07.Annee2020Jour7Exercice1;
import annees.annee2020.jour07.Annee2020Jour7Exercice2;

class Annee2020Jour07Test {

	@Test
	void exercice1() {
		assertEquals("213", new Annee2020Jour7Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("38426", new Annee2020Jour7Exercice2().lancer());
	}

}
