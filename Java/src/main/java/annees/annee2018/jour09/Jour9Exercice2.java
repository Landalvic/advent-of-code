package annees.annee2018.jour09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

import commun.Exercice;
import util.FileUtils;

public class Jour9Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Jour9Exercice2().lancer("src/main/resources/annee2018/jour09/data.txt");
	}

	@Override
	public String run(String input) throws Exception {

		List<String> liste = FileUtils.listOfLines(input);
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

		List<Integer> jeu = new LinkedList<>();
		ListIterator<Integer> iterateur = jeu.listIterator();
		iterateur.add(0);
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

		System.out.println(Arrays.asList(joueurs));
		long highscore = 0;
		for (Joueur joueur : joueurs) {
			if (highscore < joueur.getScore()) {
				highscore = joueur.getScore();
			}
		}
		return "" + highscore;
	}

	private static void next(ListIterator<Integer> iterateur, List<Integer> jeu) {
		if (!iterateur.hasNext()) {
			while (iterateur.hasPrevious()) {
				iterateur.previous();
			}
			iterateur.next();
		} else {
			iterateur.next();
		}
	}

	private static int previous(ListIterator<Integer> iterateur, List<Integer> jeu) {
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
