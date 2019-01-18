package annees.annee2015.jour13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import util.FileUtils;

public class Annee2015Jour13Exercice2 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour13Exercice2();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour13/data.txt");
		Pattern personnePattern = Pattern.compile("(.*) would .*");
		Pattern voisinPattern = Pattern.compile(".* happiness units by sitting next to (.*).");
		Pattern nombrePattern = Pattern.compile(".*(?:gain|lose) (.*) happiness units by sitting next to .*");

		Map<String, Personne> invites = new HashMap<>();

		for (String string : liste) {
			boolean gain = string.contains(" gain ");
			String personne = FileUtils.trouverPattern(string, personnePattern);
			String voisin = FileUtils.trouverPattern(string, voisinPattern);
			int nombre = FileUtils.trouverPatternInt(string, nombrePattern);

			Personne p = invites.getOrDefault(personne, new Personne(personne));
			Personne pV = invites.getOrDefault(voisin, new Personne(voisin));
			p.getAmities().put(pV, gain ? nombre : -nombre);
			invites.put(personne, p);
			invites.put(voisin, pV);
		}
		Personne vous = new Personne("Vous");
		for (Personne personne : invites.values()) {
			vous.getAmities().put(personne, 0);
			personne.getAmities().put(vous, 0);
		}
		invites.put("Vous", vous);

		List<Formation> formations = new ArrayList<>();
		for (Personne personne : invites.values()) {
			formations.addAll(personne.placer(new Formation(new ArrayList<>(), 0), invites.values().size()));
		}
		int bonheurMax = 0;
		for (Formation formation : formations) {
			bonheurMax = Math.max(formation.getBonheur(), bonheurMax);
		}
		System.out.println(bonheurMax);

	}

}
