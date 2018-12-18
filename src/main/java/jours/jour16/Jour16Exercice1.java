package jours.jour16;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import jours.jour10.Lumiere;
import util.FileUtils;

public class Jour16Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour10/data.txt");
		Pattern positionPattern = Pattern.compile("position=<(.*)> velocity.*");
		Pattern velocitePattern = Pattern.compile(".*velocity=<(.*)>");
		List<Lumiere> lignes = new ArrayList<>(liste.size());
		for (String string : liste) {
			String[] position = FileUtils.trouverPattern(string, positionPattern).split(",");
			String[] velocite = FileUtils.trouverPattern(string, velocitePattern).split(",");
			lignes.add(new Lumiere(Integer.valueOf(position[0].trim()), Integer.valueOf(position[1].trim()),
					Integer.valueOf(velocite[0].trim()), Integer.valueOf(velocite[1].trim())));
		}

	}

}
