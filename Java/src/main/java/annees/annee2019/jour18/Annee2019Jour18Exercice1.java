package annees.annee2019.jour18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour18Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour18Exercice1().lancer("src/main/resources/annee2019/jour18/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		Case[][] map = new Case[lignes.size()][lignes.get(0).length()];
		List<Nous> listNous = new ArrayList<Nous>();
		List<Cle> cles = new ArrayList<Cle>();
		for (int j = 0; j < lignes.size(); j++) {
			String string = lignes.get(j);
			for (int i = 0; i < string.length(); i++) {
				String car = "" + string.charAt(i);
				Case c = new Case(i, j);
				map[j][i] = c;
				if (StringUtils.equals(car, "#")) {
					c.setMur(true);
				} else if (StringUtils.equals(car, "@")) {
					listNous.add(new Nous(c, new ArrayList<Cle>()));
				} else if (StringUtils.equals(car, ".")) {
				} else if (StringUtils.isAllUpperCase(car)) {
					c.setPorte(car);
				} else if (StringUtils.isAllLowerCase(car)) {
					Cle cle = new Cle(car);
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
			List<Nous> newNous = Collections.synchronizedList(new ArrayList<Nous>());
			listNous.parallelStream().forEach(nous -> {
				if (nous.getCles().size() != cles.size()) {
					List<List<Case>> listDest = trouverDestination(map, nous);
					for (List<Case> chemin : listDest) {
						Case dest = chemin.get(chemin.size() - 1);
						var nouveauNous = new Nous(dest, nous.getCles());
						nouveauNous.addCle(dest.getCle());
						nouveauNous.setDistance(nous.getDistance() + chemin.size() - 1);
						newNous.add(nouveauNous);
						// visualiserMap(map, nous);
					}
				} else {
					newNous.add(nous);
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
					if (newNous.get(i).getDistance() > 1.2 * newNous.get(i + 1).getDistance()) {
						newNous.remove(i);
						i--;
					} else if (newNous.get(i + 1).getDistance() > 1.2 * newNous.get(i).getDistance()) {
						newNous.remove(i + 1);
						i--;
					}
				}
			}
			listNous = newNous;
		}
		return "" + listNous.stream().mapToInt(nous -> nous.getDistance()).min().getAsInt();
	}

	public boolean fin(List<Nous> listeNous, List<Cle> cles) {
		for (var nous : listeNous) {
			if (nous.getCles().size() != cles.size()) {
				return false;
			}
		}
		return true;
	}

	public List<List<Case>> trouverDestination(Case[][] map, Nous nous) {
		List<List<Case>> listeChemins = new ArrayList<List<Case>>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Case enCours = map[i][j];
				if (enCours.getCle() != null && !nous.avoirCle(enCours.getCle().getId())) {
					var chemins = nous.getEmplacement().deplacement(enCours, nous);
					if (chemins != null) {
						listeChemins.add(chemins);
					}
				}
			}
		}
		return listeChemins;
	}

	public void visualiserMap(Case[][] map, Nous nous) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (nous.getEmplacement().getPositionY() == i && nous.getEmplacement().getPositionX() == j) {
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
