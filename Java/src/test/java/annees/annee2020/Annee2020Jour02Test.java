package annees.annee2020;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2020.jour02.Annee2020Jour2Exercice1;
import annees.annee2020.jour02.Annee2020Jour2Exercice2;

class Annee2020Jour02Test {

	@Test
	void exercice1() {
		assertEquals("591", new Annee2020Jour2Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("335", new Annee2020Jour2Exercice2().lancer());
	}

}
