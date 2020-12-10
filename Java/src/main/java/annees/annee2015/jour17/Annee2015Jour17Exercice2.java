package annees.annee2015.jour17;

import java.util.ArrayList;
import java.util.List;

import commun.util.FileUtils;

public class Annee2015Jour17Exercice2 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour17Exercice2();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour17/data.txt");
		int lait = 150;

		List<Integer> bouteilles = new ArrayList<>();
		for (String string : liste) {
			bouteilles.add(Integer.valueOf(string));
		}

		List<Integer> indexPris = new ArrayList<>();
		List<Integer> nbrBouteilles = new ArrayList<>();
		int somme = 0;
		for (int i = 0; i < bouteilles.size(); i++) {
			if (somme + bouteilles.get(i) == lait) {
				nbrBouteilles.add(indexPris.size() + 1);
			} else if (i != bouteilles.size() - 1 && somme + bouteilles.get(i) < lait) {
				somme += bouteilles.get(i);
				indexPris.add(i);
			}
			if (i == bouteilles.size() - 1 && indexPris.size() > 0) {
				i = indexPris.remove(indexPris.size() - 1);
				somme -= bouteilles.get(i);
			}
		}
		int min = 9999999;
		int comptage = 0;
		for (Integer i : nbrBouteilles) {
			min = Math.min(min, i);
		}
		for (Integer i : nbrBouteilles) {
			if (i == min) {
				comptage++;
			}
		}
		System.out.println(comptage);

	}

}
