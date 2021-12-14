package annees.annee2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2021.jour09.Annee2021Jour9Exercice1;
import annees.annee2021.jour09.Annee2021Jour9Exercice2;

class Annee2021Jour09Test {

	@Test
	void exercice1() {
		assertEquals("575", new Annee2021Jour9Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("1019700", new Annee2021Jour9Exercice2().lancer());
	}

}
