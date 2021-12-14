package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour03.Annee2021Jour3Exercice1;
import annees.annee2021.jour03.Annee2021Jour3Exercice2;

class Annee2021Jour03Test {

	@Test
	void exercice1() {
		assertEquals("3148794", new Annee2021Jour3Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("2795310", new Annee2021Jour3Exercice2().lancer());
	}

}
