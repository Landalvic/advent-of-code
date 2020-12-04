package annees.annee2017.jour01;

import commun.Exercice;

public abstract class Annee2017Jour1 extends Exercice {

	public String runCommun(String data, int avancement) {
		int total = 0;
		for (int i = 0; i < data.length(); i++) {
			int valeur = Integer.parseInt(String.valueOf(data.charAt(i)));
			int valeurSuivante = Integer.parseInt(String.valueOf(data.charAt((i + avancement) % data.length())));
			if (valeur == valeurSuivante) {
				total += valeur;
			}
		}
		return String.valueOf(total);
	}

}
