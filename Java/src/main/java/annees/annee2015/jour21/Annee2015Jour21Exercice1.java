package annees.annee2015.jour21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import commun.util.FileUtils;

public class Annee2015Jour21Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour21Exercice1();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour21/data.txt");

		Pattern pvPattern = Pattern.compile("Hit Points: (.*)");
		Pattern degatsPattern = Pattern.compile("Damage: (.*)");
		Pattern armurePattern = Pattern.compile("Armor: (.*)");

		Joueur boss = new Joueur(0, 0, 0);
		for (String string : liste) {
			Integer pv = FileUtils.trouverPatternInt(string, pvPattern);
			if (pv != null) {
				boss.setPv(pv);
			}
			Integer degats = FileUtils.trouverPatternInt(string, degatsPattern);
			if (degats != null) {
				boss.setDegats(degats);
			}
			Integer armure = FileUtils.trouverPatternInt(string, armurePattern);
			if (armure != null) {
				boss.setArmure(armure);
			}
		}

		List<Arme> armes = new ArrayList<>();
		armes.add(new Arme("Dagger", 8, 4, 0, 1));
		armes.add(new Arme("Shortsword", 10, 5, 0, 2));
		armes.add(new Arme("Warhammer", 25, 6, 0, 3));
		armes.add(new Arme("Longsword", 40, 7, 0, 4));
		armes.add(new Arme("Greataxe", 74, 8, 0, 7));
		List<Armure> armures = new ArrayList<>();
		armures.add(new Armure("Leather", 13, 0, 1, 1));
		armures.add(new Armure("Chainmail", 31, 0, 2, 2));
		armures.add(new Armure("Splintmail", 53, 0, 3, 5));
		armures.add(new Armure("Bandedmail", 75, 0, 4, 6));
		armures.add(new Armure("Platemail", 102, 0, 5, 7));
		List<Anneau> anneauxDegats = new ArrayList<>();
		List<Anneau> anneauxArmure = new ArrayList<>();
		anneauxDegats.add(new Anneau("Damage +1", 25, 1, 0, 5));
		anneauxDegats.add(new Anneau("Damage +2", 50, 2, 0, 6));
		anneauxDegats.add(new Anneau("Damage +3", 100, 3, 0, 8));
		anneauxArmure.add(new Anneau("Defense +1", 20, 0, 1, 3));
		anneauxArmure.add(new Anneau("Defense +2", 40, 0, 2, 4));
		anneauxArmure.add(new Anneau("Defense +3", 80, 0, 3, 8));
		List<Item> itemsDegats = new ArrayList<>();
		itemsDegats.addAll(armes);
		itemsDegats.addAll(anneauxDegats);
		Collections.sort(itemsDegats, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return Integer.compare(o1.getOrdre(), o2.getOrdre());
			}
		});
		List<Item> itemsArmure = new ArrayList<>();
		itemsArmure.addAll(armures);
		itemsArmure.addAll(anneauxArmure);
		Collections.sort(itemsArmure, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return Integer.compare(o1.getOrdre(), o2.getOrdre());
			}
		});

		List<Joueur> vousGagnants = new ArrayList<>();
		int ancienDegats = 9999;
		for (int armure = 0; armure < boss.getDegats(); armure++) {
			for (int degats = 4; degats < boss.getDegats() * 2; degats++) {
				Joueur vous = new Joueur(100, degats, armure);
				Joueur joueur1 = vous;
				Joueur joueur2 = new Joueur(boss.getPv(), boss.getDegats(), boss.getArmure());
				while (joueur1.getPv() > 0 && joueur2.getPv() > 0) {
					joueur1.attaquer(joueur2);
					Joueur joueurTemp = joueur1;
					joueur1 = joueur2;
					joueur2 = joueurTemp;
				}
				if (vous.getPv() > 0) {
					if (ancienDegats > vous.getDegats()) {
						ancienDegats = vous.getDegats();
						vousGagnants.add(vous);
					}
					break;
				}
			}
		}

		int minCout = 99999;
		for (Joueur joueur : vousGagnants) {
			Equipement e = new Equipement();
			if (e.getDegats() < joueur.getDegats()) {
				for (Item item : itemsDegats) {
					e.equiper(item, joueur.getDegats() - e.getDegats());
					if (e.getDegats() >= joueur.getDegats()) {
						break;
					}
				}
			}
			if (e.getMontantArmure() < joueur.getArmure()) {
				for (Item item : itemsArmure) {
					e.equiper(item, joueur.getArmure() - e.getMontantArmure());
					if (e.getMontantArmure() >= joueur.getArmure()) {
						break;
					}
				}
			}
			if (e.getMontantArmure() > joueur.getArmure()) {
				e.setAnneau1(null);
			}
			if (e.getDegats() > joueur.getDegats()) {
				e.setAnneau1(null);
			}
			minCout = Math.min(minCout, e.cout());
		}
		System.out.println(minCout);

	}

}
