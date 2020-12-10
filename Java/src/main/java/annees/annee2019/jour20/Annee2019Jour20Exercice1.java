package annees.annee2019.jour20;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2019Jour20Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour20Exercice1().lancer("src/main/resources/annee2019/jour20/data.txt");
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
		for (int i = 0; i < portails.size(); i++) {
			for (int j = 0; j < portails.size(); j++) {
				if (i != j && StringUtils.equals(portails.get(i).getId(), portails.get(j).getId())) {
					portails.get(i).getCasesPortail().addAll(portails.get(j).getCasesPortail());
					portails.remove(j);
					j--;
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
		for (Portail portail : portails) {
			for (Case c : portail.getCasesAdjacentes()) {
				for (Case c2 : portail.getCasesAdjacentes()) {
					if (c != c2) {
						c.getCasesAdjacentes().add(c2);
					}
				}
			}
		}
		nous = getPortail(portails, "AA").getCasesAdjacentes().get(0);
		Case dest = getPortail(portails, "ZZ").getCasesAdjacentes().get(0);
		visualiserMap(map, nous);
		return "" + (nous.deplacement(dest).size() - 1);
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
