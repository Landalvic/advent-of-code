package jours.jour4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour4Exercice2 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour4/data.txt");
		Pattern datePattern = Pattern.compile("\\[(.*)\\].*");
		Pattern minutePattern = Pattern.compile(".*:(.*)\\].*");
		Pattern idGardePattern = Pattern.compile(".* #(.*) begins.*");
		List<Ligne> lignes = new ArrayList<>(liste.size());
		for (String string : liste) {
			String date = FileUtils.trouverPattern(string, datePattern);
			int minute = FileUtils.trouverPatternInt(string, minutePattern);
			Integer idGarde = FileUtils.trouverPatternInt(string, idGardePattern);
			lignes.add(new Ligne(date, minute, string, idGarde));
		}
		Collections.sort(lignes);
		HashMap<Integer, Garde> gardes = new HashMap<>();
		Garde gardeEnCours = null;
		Integer minuteDebutDodo = null;
		for (Ligne ligne : lignes) {
			if (ligne.getIdGarde() != null) {
				gardeEnCours = gardes.get(ligne.getIdGarde());
				if (gardeEnCours == null) {
					gardeEnCours = new Garde(ligne.getIdGarde());
					gardes.put(ligne.getIdGarde(), gardeEnCours);
				}
			} else if (minuteDebutDodo == null) {
				minuteDebutDodo = ligne.getMinute();
			} else {
				gardeEnCours.dormir(minuteDebutDodo, ligne.getMinute());
				minuteDebutDodo = null;
			}
		}

		Garde gardeMauvais = null;
		int minutePlusMauvaise = 0;
		int TotalPlusMauvais = 0;
		for (Garde garde : gardes.values()) {
			if (garde.minuteLaPire() >= 0) {
				int minuteLaPire = garde.getSommeil()[garde.minuteLaPire()];
				if (minuteLaPire > TotalPlusMauvais) {
					TotalPlusMauvais = minuteLaPire;
					gardeMauvais = garde;
					minutePlusMauvaise = garde.minuteLaPire();
				}
			}
		}
		System.out.println(minutePlusMauvaise * gardeMauvais.getId());

	}

}
