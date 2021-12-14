package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour04.Annee2021Jour4Exercice1;
import annees.annee2021.jour04.Annee2021Jour4Exercice2;

class Annee2021Jour04Test {

	@Test
	void exercice1() {
		assertEquals("58838", new Annee2021Jour4Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("6256", new Annee2021Jour4Exercice2().lancer());
	}

}
