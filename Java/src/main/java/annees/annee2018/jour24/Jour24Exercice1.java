package annees.annee2018.jour24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Jour24Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour24/data.txt");
		Pattern nombrePattern = Pattern.compile("(.*) units each.*");
		Pattern pvPattern = Pattern.compile(".*each with (.*) hit points.*");
		Pattern attaquePattern = Pattern.compile(".*attack that does ([0-9]*) .*");
		Pattern initiativePattern = Pattern.compile(".* at initiative (.*)");
		Pattern typeAttaquePattern = Pattern.compile(".* (.*) damage at.*");
		Pattern immunitesPattern = Pattern.compile(".*immune to (.*?)(\\)|;).*");
		Pattern faiblessesPattern = Pattern.compile(".*weak to (.*?)(\\)|;).*");
		List<Groupe> groupes = new ArrayList<>(liste.size());
		boolean systemeImmunitaire = true;
		for (String string : liste) {
			if (StringUtils.equals(string, "Infection:")) {
				systemeImmunitaire = false;
			} else if (StringUtils.equals(string, "Immune System:")) {
				systemeImmunitaire = true;
			} else if (StringUtils.isNotEmpty(string)) {
				int nbrUnites = FileUtils.trouverPatternInt(string, nombrePattern);
				int pv = FileUtils.trouverPatternInt(string, pvPattern);
				int attaque = FileUtils.trouverPatternInt(string, attaquePattern);
				int initiative = FileUtils.trouverPatternInt(string, initiativePattern);
				TypeAttaque typeAttaque = TypeAttaque.fromId(FileUtils.trouverPattern(string, typeAttaquePattern));
				String test = FileUtils.trouverPattern(string, immunitesPattern);
				List<TypeAttaque> immunites = new ArrayList<>();
				if (test != null) {
					immunites = TypeAttaque.fromId(test.split(","));
				}
				test = FileUtils.trouverPattern(string, faiblessesPattern);
				List<TypeAttaque> faiblesses = new ArrayList<>();
				if (test != null) {
					faiblesses = TypeAttaque.fromId(test.split(","));
				}
				Groupe groupe = new Groupe(systemeImmunitaire, nbrUnites, pv, attaque, typeAttaque, initiative,
						immunites, faiblesses);
				groupes.add(groupe);
			}
		}

		while (!isVainqueur(groupes)) {
			for (Groupe groupe : groupes) {
				groupe.initialiserTour();
			}
			Collections.sort(groupes, new Comparator<Groupe>() {
				@Override
				public int compare(Groupe o1, Groupe o2) {
					return -Integer.compare(o1.puissanceEffective(), o2.puissanceEffective());
				}
			});
			for (Groupe groupe : groupes) {
				if (groupe.getNbrUnites() > 0) {
					groupe.meilleureCible(groupes);
				}
			}
			Collections.sort(groupes, new Comparator<Groupe>() {
				@Override
				public int compare(Groupe o1, Groupe o2) {
					return -Integer.compare(o1.getInitiative(), o2.getInitiative());
				}
			});
			for (Groupe groupe : groupes) {
				if (groupe.getNbrUnites() > 0) {
					groupe.attaquer();
				}
			}
		}

		int nbrUnites = 0;
		for (Groupe groupe : groupes) {
			nbrUnites += groupe.getNbrUnites();
		}
		System.out.println(nbrUnites);

	}

	private static boolean isVainqueur(List<Groupe> groupes) {
		boolean immunite = false;
		boolean infection = false;
		for (Groupe groupe : groupes) {
			if (groupe.getNbrUnites() > 0) {
				if (groupe.isSystemeImmunitaire()) {
					immunite = true;
				} else {
					infection = true;
				}
			}
		}
		return !immunite || !infection;
	}

}
