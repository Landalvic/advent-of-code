package annees.annee2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2019.jour04.Annee2019Jour4Exercice1;
import annees.annee2019.jour04.Annee2019Jour4Exercice2;

class Annee2019Jour04Test {

	@Test
	void exercice1() {
		assertEquals("466", new Annee2019Jour4Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("292", new Annee2019Jour4Exercice2().lancer());
	}

}
