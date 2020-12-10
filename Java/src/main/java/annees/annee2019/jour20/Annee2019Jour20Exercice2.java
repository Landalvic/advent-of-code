package annees.annee2019.jour20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2019Jour20Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour20Exercice2().lancer("src/main/resources/annee2019/jour20/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		Case[][] map = new Case[lignes.size()][lignes.get(0).length()];
		Case nous = null;
		List<Portail> portails = new ArrayList<Portail>();
		for (int j = 0; j < lignes.size(); j++) {
			String string = lignes.get(j);
			for (int i = 0; i < string.length(); i++) {
				String car = "" + string.charAt(i);
				Case c = new Case(i, j);
				map[j][i] = c;
				if (StringUtils.equals(car, "#")) {
					c.setMur(true);
				} else if (StringUtils.equals(car, " ")) {
					c.setMur(true);
				} else if (StringUtils.equals(car, ".")) {
				} else if (StringUtils.isAllUpperCase(car)) {
					c.setMur(true);
					Portail p = new Portail("" + car);
					if (i > 3 && i < string.length() - 3 && j > 3 && j < lignes.size() - 3) {
						p.setInterieur(true);
					} else {
						p.setInterieur(false);
					}
					p.getCasesPortail().add(c);
					c.setPortail(p);
					portails.add(p);
				}
				if (i > 0) {
					c.setOuest(map[j][i - 1]);
				}
				if (j > 0) {
					c.setNord(map[j - 1][i]);
				}
			}
		}
		for (Case[] cases : map) {
			for (Case case1 : cases) {
				if (case1.getPortail() != null) {
					for (Case caseadj : case1.getCasesAdjacentes()) {
						if (caseadj.getPortail() != null && caseadj.getPortail() != case1.getPortail()) {
							portails.remove(caseadj.getPortail());
							case1.getPortail().setId2(caseadj.getPortail().getId1());
							case1.getPortail().getCasesPortail().addAll(caseadj.getPortail().getCasesPortail());
							caseadj.setPortail(case1.getPortail());
						}
					}
				}
			}
		}
		for (Portail portail : portails) {
			for (Case c : portail.getCasesPortail()) {
				for (Case cAdj : c.getCasesAdjacentes()) {
					if (!cAdj.isMur()) {
						portail.getCasesAdjacentes().add(cAdj);
					}
				}
			}
		}
		for (int i = 0; i < portails.size(); i++) {
			for (int j = 0; j < portails.size(); j++) {
				if (i != j && StringUtils.equals(portails.get(i).getId(), portails.get(j).getId())) {
					portails.get(i).getCasesPortail().addAll(portails.get(j).getCasesPortail());
					portails.get(i).getCasesAdjacentes().addAll(portails.get(j).getCasesAdjacentes());
					portails.remove(j);
					j--;
				}
			}
		}
		nous = getPortail(portails, "AA").getCasesAdjacentes().get(0);
		visualiserMap(map, nous);
		portails.remove(getPortail(portails, "AA"));
		var portailZZ = getPortail(portails, "ZZ");
		List<Chemin> chemins = new ArrayList<Chemin>();
		Chemin cheminDepart = new Chemin(nous, 0);
		chemins.add(cheminDepart);
		Fin fin = new Fin();
		while (fin.getChemin() == null || chemins.size() > 1) {
			List<Chemin> newChemins = Collections.synchronizedList(new ArrayList<Chemin>());
			chemins.parallelStream().forEach(chemin -> {
				for (Portail portail : portails) {
					var depl = chemin.getDepart().deplacement(portail.getCasesAdjacentes().get(0));
					if (depl != null) {
						if (portail == portailZZ) {
							if (chemin.getProfondeur() == 0) {
								fin.setChemin(creerChemin(depl, portail.getCasesAdjacentes().get(0), chemin, portail));
								continue;
							} else {
								continue;
							}
						}
						if (chemin.verifierChemin(portail.getCasesAdjacentes().get(0)) && (chemin.getProfondeur() != 0
								|| portail.isInterieur(portail.getCasesAdjacentes().get(0)))) {
							newChemins.add(creerChemin(depl, portail.getCasesAdjacentes().get(1), chemin, portail));
						}
					}
					if (portail != portailZZ) {
						depl = chemin.getDepart().deplacement(portail.getCasesAdjacentes().get(1));
						if (depl != null) {
							if (chemin.verifierChemin(portail.getCasesAdjacentes().get(1))
									&& (chemin.getProfondeur() != 0
											|| portail.isInterieur(portail.getCasesAdjacentes().get(1)))) {
								newChemins.add(creerChemin(depl, portail.getCasesAdjacentes().get(0), chemin, portail));
							}
						}
					}
				}
			});
			if (fin.getChemin() != null) {
				for (Chemin chemin2 : newChemins) {
					if (chemin2.getDeplacement() >= fin.getChemin().getDeplacement()) {

					}
				}
			}
			chemins = newChemins.stream().filter(
					chemin2 -> fin.getChemin() == null || chemin2.getDeplacement() <= fin.getChemin().getDeplacement())
					.collect(Collectors.toList());
		}
		return "" + (fin.getChemin().getDeplacement() - 1);
	}

	public Chemin creerChemin(List<Case> depl, Case destination, Chemin ancien, Portail portail) {
		var newChemin = new Chemin(destination, ancien.getDeplacement() + depl.size());
		newChemin.getParcours().addAll(ancien.getParcours());
		int profondeur = !portail.isInterieur(destination) ? ancien.getProfondeur() + 1 : ancien.getProfondeur() - 1;
		newChemin.getParcours().add(new Etape(depl.get(depl.size() - 1), ancien.getProfondeur(), portail));
		newChemin.getParcours().add(new Etape(destination, profondeur, portail));
		newChemin.setProfondeur(profondeur);
		return newChemin;
	}

	public Portail getPortail(List<Portail> portails, String id) {
		for (Portail portail : portails) {
			if (StringUtils.equals(id, portail.getId())) {
				return portail;
			}
		}
		return null;
	}

	public void visualiserMap(Case[][] map, Case nous) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (nous.getPositionY() == i && nous.getPositionX() == j) {
					System.out.print("@");
				} else {
					Case case1 = map[i][j];
					if (case1.isMur()) {
						System.out.print("#");
					} else {
						System.out.print(".");
					}
				}
			}
			System.out.println();
		}
	}

}
