package annees.annee2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import annees.annee2019.jour05.Annee2019Jour5Exercice1;
import annees.annee2019.jour05.Annee2019Jour5Exercice2;

class Annee2019Jour05Test {

	@Test
	void exercice1() {
		assertEquals("13787043", new Annee2019Jour5Exercice1().lancer());
	}

	@Test
	void exercice2() {
		assertEquals("3892695", new Annee2019Jour5Exercice2().lancer());
	}

}
