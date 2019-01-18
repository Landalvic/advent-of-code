package annees.annee2018.jour03;

import java.util.concurrent.atomic.AtomicInteger;

public class Annee2018Jour3Exercice1 extends Annee2018Jour3 {

	public static void main(String[] args) {
		new Annee2018Jour3Exercice1().lancer("src/main/resources/annee2018/jour03/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		inputToDemandes(input);
		int total = 0;
		for (AtomicInteger[] bande : tissu) {
			for (AtomicInteger atomicInteger : bande) {
				if (atomicInteger != null && atomicInteger.get() >= 2) {
					total++;
				}
			}
		}
		return String.valueOf(total);
	}

}
