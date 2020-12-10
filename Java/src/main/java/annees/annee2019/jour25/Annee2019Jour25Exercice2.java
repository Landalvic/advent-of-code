package annees.annee2019.jour25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import annees.annee2019.IntCode;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2019Jour25Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour25Exercice2().lancer("src/main/resources/annee2019/jour25/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		code.init();
		List<Long> retour = code.lancerAttendreInput();
		String texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("north\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("take mutex\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("east\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("east\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("east\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("take whirled peas\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("west\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("west\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("west\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("south\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("west\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("take space law space brochure\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("north\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("take loom\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("south\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("south\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("take hologram\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("west\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("take manifold\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("east\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("north\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("east\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("south\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("take cake\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("west\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("south\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("take easter egg\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("north\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("east\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		// 50étoiles
		retour = code.lancerAttendreInput(code.ecrireAscii("west\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("south\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);
		retour = code.lancerAttendreInput(code.ecrireAscii("south\n"));
		texte = code.lireAscii(retour);
		System.out.println(texte);

		List<String> objets = new ArrayList<String>(Arrays.asList("whirled peas", "cake", "manifold", "easter egg",
				"mutex", "loom", "hologram", "space law space brochure"));
		a: for (int i = 0; i < objets.size(); i++) {
			for (int j = 0; j < objets.size(); j++) {
				for (int k = 0; k < objets.size(); k++) {
					for (int l = 0; l < objets.size(); l++) {
						if (i != j && j != k && i != k && i != l && j != l && l != k) {
							List<String> objetsTest = new ArrayList<String>();
							objetsTest.add(objets.get(i));
							objetsTest.add(objets.get(j));
							objetsTest.add(objets.get(k));
							objetsTest.add(objets.get(l));
							for (String objet : objetsTest) {
								retour = code.lancerAttendreInput(code.ecrireAscii("drop " + objet + "\n"));
								texte = code.lireAscii(retour);
								System.out.println(texte);
							}
							retour = code.lancerAttendreInput(code.ecrireAscii("south\n"));
							texte = code.lireAscii(retour);
							System.out.println(texte);
							if (texte.contains("Alert!")) {
								for (String objet : objetsTest) {
									retour = code.lancerAttendreInput(code.ecrireAscii("take " + objet + "\n"));
									texte = code.lireAscii(retour);
									System.out.println(texte);
								}
							} else {
								break a;
							}
						}
					}
				}
			}
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
