package annees.annee2019.jour25;

import java.util.ArrayList;
import java.util.List;

import annees.annee2019.IntCode;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2019Jour25Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour25Exercice1().lancer("src/main/resources/annee2019/jour25/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		code.init();
		List<Case> map = new ArrayList<Case>();
		code.lancerAttendreInput();
		var depart = creerCase(map, 0, 0, false);
		depart.setVerifie(true);
		map.add(depart);
		var dest = trouverCase(map);
		var chemin = depart.deplacement(dest);
		while (!code.isFini()) {
			String texteInput = "";
			String texte = "";
			if (chemin == null) {

			}
			for (int i = 0; i < chemin.size() - 1; i++) {
				var prec = chemin.get(i);
				var suiv = chemin.get(i + 1);
				if (suiv.getPositionX() > prec.getPositionX()) {
					texteInput = "east\n";
				} else if (suiv.getPositionX() < prec.getPositionX()) {
					texteInput = "west\n";
				} else if (suiv.getPositionY() < prec.getPositionY()) {
					texteInput = "north\n";
				} else if (suiv.getPositionY() > prec.getPositionY()) {
					texteInput = "south\n";
				}
				System.out.println(texteInput);
				List<Long> retour = code.lancerAttendreInput(code.ecrireAscii(texteInput));
				texte = code.lireAscii(retour);
				System.out.println(texte);
			}
			visualiserMap(map, depart);
			dest.setVerifie(true);
			if (!texte.contains("north")) {
				dest.setNord(new Case(dest.getPositionX(), dest.getPositionY() - 1, true));
				dest.getNord().setVerifie(true);
				map.add(dest.getNord());
			}
			if (!texte.contains("south")) {
				dest.setSud(new Case(dest.getPositionX(), dest.getPositionY() + 1, true));
				dest.getSud().setVerifie(true);
				map.add(dest.getSud());
			}
			if (!texte.contains("west")) {
				dest.setOuest(new Case(dest.getPositionX() - 1, dest.getPositionY(), true));
				dest.getOuest().setVerifie(true);
				map.add(dest.getOuest());
			}
			if (!texte.contains("east")) {
				dest.setEst(new Case(dest.getPositionX() + 1, dest.getPositionY(), true));
				dest.getEst().setVerifie(true);
				map.add(dest.getEst());
			}
			depart = dest;
			dest = trouverCase(map);
			chemin = depart.deplacement(dest);
			visualiserMap(map, depart);
		}
		return "";
	}

	public void visualiserMap(List<Case> map, Case nous) {
		int xmin = map.stream().mapToInt(c -> c.getPositionX()).min().getAsInt();
		int xmax = map.stream().mapToInt(c -> c.getPositionX()).max().getAsInt();
		int ymin = map.stream().mapToInt(c -> c.getPositionY()).min().getAsInt();
		int ymax = map.stream().mapToInt(c -> c.getPositionY()).max().getAsInt();
		for (int i = ymin; i <= ymax; i++) {
			for (int j = xmin; j <= xmax; j++) {
				boolean rien = true;
				for (Case case1 : map) {
					if (case1.getPositionX() == j && case1.getPositionY() == i) {
						if (nous == case1) {
							System.out.print("X");
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
					map.add(case1.getNord());
					return case1.getNord();
				}
				if (case1.getEst() == null) {
					case1.setEst(creerCase(map, case1.getPositionX() + 1, case1.getPositionY(), false));
					map.add(case1.getEst());
					return case1.getEst();
				}
				if (case1.getSud() == null) {
					case1.setSud(creerCase(map, case1.getPositionX(), case1.getPositionY() + 1, false));
					map.add(case1.getSud());
					return case1.getSud();
				}
				if (case1.getOuest() == null) {
					case1.setOuest(creerCase(map, case1.getPositionX() - 1, case1.getPositionY(), false));
					map.add(case1.getOuest());
					return case1.getOuest();
				}
			}
		}
		return null;
	}

	private Case creerCase(List<Case> map, int positionX, int positionY, boolean mur) {
		Case dest = new Case(positionX, positionY, mur);
		dest.setOuest(trouverCase(map, positionX - 1, positionY));
		dest.setNord(trouverCase(map, positionX, positionY - 1));
		dest.setEst(trouverCase(map, positionX + 1, positionY));
		dest.setSud(trouverCase(map, positionX, positionY + 1));
		return dest;
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
