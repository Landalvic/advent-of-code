package jours.jour3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour3Exercice2 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour3/data.txt");
		Pattern distanceGauchePattern = Pattern.compile(".* @ (.*),.*");
		Pattern distanceHautPattern = Pattern.compile(".*,(.*): .*");
		Pattern largeurPattern = Pattern.compile(".*: (.*)x.*");
		Pattern hauteurPattern = Pattern.compile(".*x(.*)");
		Pattern idPattern = Pattern.compile("#(.*) @ .*");
		AtomicInteger[][] tissu = new AtomicInteger[1000][1000];
		List<Demande> demandes = new ArrayList<>(liste.size());
		for (String string : liste) {
			int distanceGauche = FileUtils.trouverPatternInt(string, distanceGauchePattern);
			int distanceHaut = FileUtils.trouverPatternInt(string, distanceHautPattern);
			int largeur = FileUtils.trouverPatternInt(string, largeurPattern);
			int hauteur = FileUtils.trouverPatternInt(string, hauteurPattern);
			int id = FileUtils.trouverPatternInt(string, idPattern);
			Demande demande = new Demande(id);
			for (int i = 0; i < largeur; i++) {
				for (int j = 0; j < hauteur; j++) {
					AtomicInteger integer = tissu[i + distanceGauche][j + distanceHaut];
					if (integer == null) {
						integer = new AtomicInteger(0);
						tissu[i + distanceGauche][j + distanceHaut] = integer;
					}
					integer.incrementAndGet();
					demande.getMorceaux().add(integer);
				}
			}
			demandes.add(demande);
		}
		for (Demande demande : demandes) {
			if (demande.isSeul()) {
				System.out.println(demande.getId());
			}
		}
	}

}
