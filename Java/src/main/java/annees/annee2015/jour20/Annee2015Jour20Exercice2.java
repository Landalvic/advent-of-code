package annees.annee2015.jour20;

import java.util.List;

import util.MathUtils;

public class Annee2015Jour20Exercice2 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour20Exercice2();
	}

	@Override
	public void run() {
		int input = 29000000;

		int numeroMaison = input / 45;// 705600;
		int total = 0;
		while (total < input) {
			numeroMaison++;
			List<Long> diviseurs = MathUtils.listeDiviseurs(numeroMaison);
			total = 0;
			for (Long integer : diviseurs) {
				if (numeroMaison / integer <= 50) {
					total += integer * 11;
				}
			}
		}
		System.out.println(total);
		System.out.println(numeroMaison);

	}

}
