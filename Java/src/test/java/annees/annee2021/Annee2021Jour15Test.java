package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour12.Annee2021Jour12Exercice1;
import annees.annee2021.jour12.Annee2021Jour12Exercice2;

class Annee2021Jour15Test {

	@Test
	void exercice1() {
		assertEquals("589", new Annee2021Jour12Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("2885", new Annee2021Jour12Exercice2().lancer());
	}

}
