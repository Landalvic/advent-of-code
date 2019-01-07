package annees.annee2018.jour9;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour9Exercice1 {

	public static void main(String[] args) {

		List<String> liste = FileUtils.lireFichier("./jour9/data.txt");
		Pattern nbrJoueursPattern = Pattern.compile("(.*) players.*");
		Pattern dernierDePattern = Pattern.compile(".*worth (.*) points");
		int nbrJoueurs = 0;
		int dernierDe = 0;
		for (String string : liste) {
			nbrJoueurs = FileUtils.trouverPatternInt(string, nbrJoueursPattern);
			dernierDe = FileUtils.trouverPatternInt(string, dernierDePattern);
		}

		Joueur[] joueurs = new Joueur[nbrJoueurs];
		for (int i = 0; i < nbrJoueurs; i++) {
			joueurs[i] = new Joueur();
		}

		List<Integer> jeu = new ArrayList<>();
		jeu.add(0);
		int lastIndex = 1;
		for (int de = 1; de <= dernierDe; de++) {
			if (de % 23 == 0) {
				lastIndex -= 7;
				if (lastIndex < 0) {
					lastIndex += jeu.size();
				}
				int scoreAjout = jeu.remove(lastIndex);
				joueurs[(de - 1) % joueurs.length].addScore(de + scoreAjout);
			} else {
				lastIndex += 2;
				if (lastIndex > jeu.size()) {
					lastIndex = lastIndex % jeu.size();
				}
				jeu.add(lastIndex, de);
			}
		}
		long highscore = 0;
		for (Joueur joueur : joueurs) {
			if (highscore < joueur.getScore()) {
				highscore = joueur.getScore();
			}
		}
		System.out.println(highscore);
	}

}
