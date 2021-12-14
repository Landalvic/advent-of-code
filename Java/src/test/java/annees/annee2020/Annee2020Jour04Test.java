package annees.annee2020;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2020.jour04.Annee2020Jour4Exercice1;
import annees.annee2020.jour04.Annee2020Jour4Exercice2;

class Annee2020Jour04Test {

	@Test
	void exercice1() {
		assertEquals("202", new Annee2020Jour4Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("137", new Annee2020Jour4Exercice2().lancer());
	}

}
