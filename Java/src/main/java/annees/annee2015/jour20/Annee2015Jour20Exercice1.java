package annees.annee2015.jour20;

import java.util.List;

import commun.util.MathUtils;

public class Annee2015Jour20Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour20Exercice1();
	}

	@Override
	public void run() {
		int input = 29000000;

		int numeroMaison = input / 45;// 665280;
		int total = 0;
		while (total < input) {
			numeroMaison++;
			List<Long> diviseurs = MathUtils.listeDiviseurs(numeroMaison);
			total = 0;
			for (Long integer : diviseurs) {
				total += integer * 10;
			}
		}
		System.out.println(total);
		System.out.println(numeroMaison);

	}

}
