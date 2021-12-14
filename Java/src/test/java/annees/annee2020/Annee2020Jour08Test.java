package annees.annee2020;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2020.jour08.Annee2020Jour8Exercice1;
import annees.annee2020.jour08.Annee2020Jour8Exercice2;

class Annee2020Jour08Test {

	@Test
	void exercice1() {
		assertEquals("1475", new Annee2020Jour8Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("1270", new Annee2020Jour8Exercice2().lancer());
	}

}
