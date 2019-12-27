package annees.annee2019.jour15;

import java.util.ArrayList;
import java.util.List;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour15Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour15Exercice2().lancer("src/main/resources/annee2019/jour15/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		Robot robot = new Robot(50, 50);
		List<Case> map = new ArrayList<Case>();
		Case depart = new Case(0, 0, false);
		Case arrivee = null;
		depart.setVerifie(true);
		map.add(depart);
		robot.setPosition(depart);
		Case dest = null;
		int depl = 0;
		while (true) {
			depl++;
			System.out.println(depl);
			if (depl == 360) {
				System.out.println("stop");
			}
			dest = trouverCase(map);
			if (dest == null) {
				break;
			}
			if (!map.contains(dest)) {
				map.add(dest);
			}
			var chemins = robot.getPosition().deplacement(dest);
			try {
				Direction dir = robot.getPosition().getDirection(chemins.get(1));
				long retour = code.lancerFirstOutput(dir.getIntCode());
				if (retour == 0) {
					chemins.get(1).setMur(true);
					chemins.get(1).setVerifie(true);
				} else if (retour == 1) {
					chemins.get(1).setVerifie(true);
					robot.setPosition(chemins.get(1));
				} else if (retour == 2) {
					chemins.get(1).setVerifie(true);
					robot.setPosition(chemins.get(1));
					arrivee = chemins.get(1);
				}
			} catch (Exception e) {
				visualiserMap(map, robot);
				map.remove(map.size() - 1);
				trouverCase(map);
				break;
			}
		}
		arrivee.setOxygene(true);
		int nbr = 0;
		while (true) {
			boolean reste = false;
			List<Case> aTraiter = new ArrayList<Case>();
			for (Case case1 : map) {
				if (!case1.isMur()) {
					if (case1.isOxygene()) {
						aTraiter.add(case1);
					} else {
						reste = true;
					}
				}
			}
			if (!reste) {
				break;
			}
			nbr++;
			for (Case case1 : aTraiter) {
				for (Case case2 : case1.getCasesAdjacentes()) {
					if (!case2.isMur()) {
						case2.setOxygene(true);
					}
				}
			}
		}
		visualiserMap(map, robot);
		return "" + nbr;
	}

	public void visualiserMap(List<Case> map, Robot robot) {
		int xmin = map.stream().mapToInt(c -> c.getPositionX()).min().getAsInt();
		int xmax = map.stream().mapToInt(c -> c.getPositionX()).max().getAsInt();
		int ymin = map.stream().mapToInt(c -> c.getPositionY()).min().getAsInt();
		int ymax = map.stream().mapToInt(c -> c.getPositionY()).max().getAsInt();
		for (int i = ymin; i <= ymax; i++) {
			for (int j = xmin; j <= xmax; j++) {
				boolean rien = true;
				for (Case case1 : map) {
					if (case1.getPositionX() == j && case1.getPositionY() == i) {
						if (robot.getPosition() == case1) {
							System.out.print("X");
						} else if (case1.isOxygene()) {
							System.out.print("O");
						} else {
							System.out.print(case1.isMur() ? "#" : ".");
						}
						rien = false;
						break;
					}
				}
				if (rien) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public Case trouverCase(List<Case> map) {
		for (int i = map.size() - 1; i >= 0; i--) {
			Case case1 = map.get(i);
			if (!case1.isVerifie()) {
				return case1;
			}
			if (!case1.isMur()) {
				if (case1.getNord() == null) {
					case1.setNord(creerCase(map, case1.getPositionX(), case1.getPositionY() - 1, false));
					return case1.getNord();
				}
				if (case1.getEst() == null) {
					case1.setEst(creerCase(map, case1.getPositionX() + 1, case1.getPositionY(), false));
					return case1.getEst();
				}
				if (case1.getSud() == null) {
					case1.setSud(creerCase(map, case1.getPositionX(), case1.getPositionY() + 1, false));
					return case1.getSud();
				}
				if (case1.getOuest() == null) {
					case1.setOuest(creerCase(map, case1.getPositionX() - 1, case1.getPositionY(), false));
					return case1.getOuest();
				}
			}
		}
		return null;
	}

	private Case creerCase(List<Case> map, int positionX, int positionY, boolean mur) {
		Case newCase = new Case(positionX, positionY, mur);
		newCase.setOuest(trouverCase(map, positionX - 1, positionY));
		newCase.setNord(trouverCase(map, positionX, positionY - 1));
		newCase.setEst(trouverCase(map, positionX + 1, positionY));
		newCase.setSud(trouverCase(map, positionX, positionY + 1));
		return newCase;
	}

	private Case trouverCase(List<Case> map, int x, int y) {
		for (Case case1 : map) {
			if (case1.getPositionX() == x && case1.getPositionY() == y) {
				return case1;
			}
		}
		return null;
	}

}
