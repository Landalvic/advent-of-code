package annees.annee2020;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2020.jour05.Annee2020Jour5Exercice1;
import annees.annee2020.jour05.Annee2020Jour5Exercice2;

class Annee2020Jour05Test {

	@Test
	void exercice1() {
		assertEquals("976", new Annee2020Jour5Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("685", new Annee2020Jour5Exercice2().lancer());
	}

}
