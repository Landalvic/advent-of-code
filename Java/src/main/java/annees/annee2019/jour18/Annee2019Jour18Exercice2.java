package annees.annee2019.jour18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour18Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour18Exercice2().lancer("src/main/resources/annee2019/jour18/data2.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		Case[][] map = new Case[lignes.size()][lignes.get(0).length()];
		List<Dieu> listNous = new ArrayList<Dieu>();
		listNous.add(new Dieu());
		List<Cle> cles = new ArrayList<>();
		for (int j = 0; j < lignes.size(); j++) {
			String string = lignes.get(j);
			for (int i = 0; i < string.length(); i++) {
				String car = "" + string.charAt(i);
				Case c = new Case(i, j);
				map[j][i] = c;
				if (StringUtils.equals(car, "#")) {
					c.setMur(true);
				} else if (StringUtils.equals(car, "@")) {
					Nous nous = new Nous(c, new ArrayList<Cle>());
					if (i < string.length() / 2 && j < lignes.size()) {
						nous.setZone(Zone.HAUT_GAUCHE);
					} else if (i > string.length() / 2 && j < lignes.size()) {
						nous.setZone(Zone.HAUT_DROIT);
					} else if (i < string.length() / 2 && j > lignes.size()) {
						nous.setZone(Zone.BAS_GAUCHE);
					} else if (i > string.length() / 2 && j > lignes.size()) {
						nous.setZone(Zone.BAS_DROIT);
					}
					listNous.get(0).getRobots().add(nous);
				} else if (StringUtils.equals(car, ".")) {
				} else if (StringUtils.isAllUpperCase(car)) {
					c.setPorte(car);
				} else if (StringUtils.isAllLowerCase(car)) {
					Cle cle = new Cle(car);
					if (i < string.length() / 2 && j < lignes.size()) {
						cle.setZone(Zone.HAUT_GAUCHE);
					} else if (i > string.length() / 2 && j < lignes.size()) {
						cle.setZone(Zone.HAUT_DROIT);
					} else if (i < string.length() / 2 && j > lignes.size()) {
						cle.setZone(Zone.BAS_GAUCHE);
					} else if (i > string.length() / 2 && j > lignes.size()) {
						cle.setZone(Zone.BAS_DROIT);
					}
					cles.add(cle);
					c.setCle(cle);
				}
				if (i > 0) {
					c.setOuest(map[j][i - 1]);
				}
				if (j > 0) {
					c.setNord(map[j - 1][i]);
				}
			}
		}
		visualiserMap(map, listNous.get(0));
		while (!fin(listNous, cles)) {
			List<Dieu> newNous = Collections.synchronizedList(new ArrayList<Dieu>());
			listNous.parallelStream().forEach(dieu -> {
				if (dieu.tailleCles() != cles.size()) {
					List<Nous> robots = new ArrayList<Nous>(dieu.getRobots());
					for (Nous nous : robots) {
						List<List<Case>> listDest = trouverDestination(map, dieu, nous);
						for (List<Case> chemin : listDest) {
							Case dest = chemin.get(chemin.size() - 1);
							var nouveauDieu = new Dieu(dieu, nous);
							var nouveauNous = new Nous(dest, nous.getCles());
							nouveauNous.addCle(dest.getCle());
							nouveauNous.setZone(nous.getZone());
							nouveauNous.setDistance(nous.getDistance() + chemin.size() - 1);
							nouveauDieu.getRobots().add(nouveauNous);
							newNous.add(nouveauDieu);
							// visualiserMap(map, nous);
						}
					}
				} else {
					newNous.add(dieu);
				}
			});
			System.out.println(newNous.size());
			Collections.sort(newNous);
			for (int i = 0; i < newNous.size() - 1; i++) {
				if (StringUtils.equals(newNous.get(i).id(), newNous.get(i + 1).id())) {
					if (newNous.get(i).getDistance() > newNous.get(i + 1).getDistance()) {
						newNous.remove(i);
					} else {
						newNous.remove(i + 1);
					}
					i--;
				} else if (StringUtils.equals(newNous.get(i).id2(), newNous.get(i + 1).id2())) {
					if (newNous.get(i).getDistance() > newNous.get(i + 1).getDistance()) {
						newNous.remove(i);
						i--;
					} else if (newNous.get(i + 1).getDistance() > newNous.get(i).getDistance()) {
						newNous.remove(i + 1);
						i--;
					}
				}
			}
			listNous = newNous;
		}
		return "" + listNous.stream().mapToInt(nous -> nous.getDistance()).min().getAsInt();
	}

	public boolean fin(List<Dieu> listeNous, List<Cle> cles) {
		for (var nous : listeNous) {
			if (nous.tailleCles() != cles.size()) {
				return false;
			}
		}
		return true;
	}

	public List<List<Case>> trouverDestination(Case[][] map, Dieu dieu, Nous nous) {
		List<List<Case>> listeChemins = new ArrayList<List<Case>>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Case enCours = map[i][j];
				if (enCours.getCle() != null && enCours.getCle().getZone() == nous.getZone()
						&& !dieu.avoirCle(enCours.getCle().getId())) {
					var chemins = nous.getEmplacement().deplacement(enCours, dieu, nous);
					if (chemins != null) {
						listeChemins.add(chemins);
					}
				}
			}
		}
		return listeChemins;
	}

	public void visualiserMap(Case[][] map, Dieu nous) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (nous.getRobots().get(0).getEmplacement().getPositionY() == i
						&& nous.getRobots().get(0).getEmplacement().getPositionX() == j) {
					System.out.print("@");
				} else {
					Case case1 = map[i][j];
					if (case1.isMur()) {
						System.out.print("#");
					} else if (case1.getPorte() != null) {
						System.out.print(case1.getPorte());
					} else if (case1.getCle() != null) {
						System.out.print(case1.getCle());
					} else {
						System.out.print(".");
					}
				}
			}
			System.out.println();
		}
	}

}
