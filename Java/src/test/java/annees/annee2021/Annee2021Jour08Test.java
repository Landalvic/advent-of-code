package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour08.Annee2021Jour8Exercice1;
import annees.annee2021.jour08.Annee2021Jour8Exercice2;

class Annee2021Jour08Test {

	@Test
	void exercice1() {
		assertEquals("543", new Annee2021Jour8Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("994266", new Annee2021Jour8Exercice2().lancer());
	}

}
