package annees.annee2020;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2020.jour03.Annee2020Jour3Exercice1;
import annees.annee2020.jour03.Annee2020Jour3Exercice2;

class Annee2020Jour03Test {

	@Test
	void exercice1() {
		assertEquals("195", new Annee2020Jour3Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("3772314000", new Annee2020Jour3Exercice2().lancer());
	}

}
