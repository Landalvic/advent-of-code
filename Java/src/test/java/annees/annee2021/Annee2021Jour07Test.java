package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour07.Annee2021Jour7Exercice1;
import annees.annee2021.jour07.Annee2021Jour7Exercice2;

class Annee2021Jour07Test {

	@Test
	void exercice1() {
		assertEquals("333755", new Annee2021Jour7Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("94017638", new Annee2021Jour7Exercice2().lancer());
	}

}
