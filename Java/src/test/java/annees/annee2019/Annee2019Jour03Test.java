package annees.annee2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2019.jour03.Annee2019Jour3Exercice1;
import annees.annee2019.jour03.Annee2019Jour3Exercice2;

class Annee2019Jour03Test {

	@Test
	void exercice1() {
		assertEquals("731", new Annee2019Jour3Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("5672", new Annee2019Jour3Exercice2().lancer());
	}

}
