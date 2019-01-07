package annees.annee2018.jour9;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour9Exercice2 {

	public static void main(String[] args) {

		List<String> liste = FileUtils.lireFichier("./jour9/data.txt");
		Pattern nbrJoueursPattern = Pattern.compile("(.*) players.*");
		Pattern dernierDePattern = Pattern.compile(".*worth (.*) points");
		int nbrJoueurs = 0;
		int dernierDe = 0;
		for (String string : liste) {
			nbrJoueurs = FileUtils.trouverPatternInt(string, nbrJoueursPattern);
			dernierDe = FileUtils.trouverPatternInt(string, dernierDePattern) * 100;
		}

		Joueur[] joueurs = new Joueur[nbrJoueurs];
		for (int i = 0; i < nbrJoueurs; i++) {
			joueurs[i] = new Joueur();
		}

		LinkedList<Integer> jeu = new LinkedList<>();
		jeu.add(0);
		ListIterator<Integer> iterateur = jeu.listIterator();
		next(iterateur, jeu);
		int de = 0;
		while (de < dernierDe) {
			de++;
			if (de % 23 == 0) {
				previous(iterateur, jeu);
				previous(iterateur, jeu);
				previous(iterateur, jeu);
				previous(iterateur, jeu);
				previous(iterateur, jeu);
				previous(iterateur, jeu);
				previous(iterateur, jeu);
				int scoreAjout = previous(iterateur, jeu);
				iterateur.remove();
				next(iterateur, jeu);
				joueurs[(de - 1) % joueurs.length].addScore(de + scoreAjout);
			} else {
				next(iterateur, jeu);
				iterateur.add(de);
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

	private static void next(ListIterator<Integer> iterateur, LinkedList<Integer> jeu) {
		if (!iterateur.hasNext()) {
			while (iterateur.hasPrevious()) {
				iterateur.previous();
			}
			iterateur.next();
		} else {
			iterateur.next();
		}
	}

	private static int previous(ListIterator<Integer> iterateur, LinkedList<Integer> jeu) {
		int value = 0;
		value = iterateur.previous();
		if (!iterateur.hasPrevious()) {
			while (iterateur.hasNext()) {
				value = iterateur.next();
			}
		}
		return value;
	}

}
