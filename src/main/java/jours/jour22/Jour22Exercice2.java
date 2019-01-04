package jours.jour22;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.FileUtils;

public class Jour22Exercice2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		List<String> liste = FileUtils.lireFichier("./jour22/data.txt");

		int profondeur = Integer.valueOf(liste.get(0).split(" ")[1]);
		int positionXCible = Integer.valueOf(liste.get(1).split(" ")[1].split(",")[0]);
		int positionYCible = Integer.valueOf(liste.get(1).split(" ")[1].split(",")[1]);
		Region[][] map = new Region[(positionXCible * 2) + 1][(positionYCible * 2) + 1];

		for (int i = 0; i <= positionXCible * 2; i++) {
			for (int j = 0; j <= positionYCible * 2; j++) {
				int indiceGeologique;
				if (i == 0 && j == 0) {
					indiceGeologique = 0;
				} else if (i == positionXCible && j == positionYCible) {
					indiceGeologique = 0;
				} else if (i == 0) {
					indiceGeologique = j * 48271;
				} else if (j == 0) {
					indiceGeologique = i * 16807;
				} else {
					indiceGeologique = map[i - 1][j].getNiveauErosion() * map[i][j - 1].getNiveauErosion();
				}
				map[i][j] = new Region(i, j, indiceGeologique, (indiceGeologique + profondeur) % 20183);
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (i - 1 >= 0) {
					map[i][j].getRegionsAdjacentes().add(map[i - 1][j]);
				}
				if (j - 1 >= 0) {
					map[i][j].getRegionsAdjacentes().add(map[i][j - 1]);
				}
				if (i + 1 < map.length) {
					map[i][j].getRegionsAdjacentes().add(map[i + 1][j]);
				}
				if (j + 1 < map[0].length) {
					map[i][j].getRegionsAdjacentes().add(map[i][j + 1]);
				}
			}
		}

		Region cible = map[positionXCible][positionYCible];
		Chemin cheminDepart = new Chemin(new ArrayList<>(), Equipement.TORCHE, 0);
		cheminDepart.getChemin().add(map[0][0]);
		List<Chemin> chemins = new ArrayList<>();
		List<Chemin> newChemins = new ArrayList<>();
		chemins.add(cheminDepart);
		newChemins.add(cheminDepart);
		List<RegionEquipementWrapper> regionsDejaVues = new ArrayList<>();
		regionsDejaVues.add(new RegionEquipementWrapper(map[0][0], Equipement.TORCHE, 0));
		Chemin meilleurChemin = null;
		int distanceMin = cheminDepart.distance(cible);
		while (meilleurChemin == null) {
			chemins = newChemins;
			newChemins = new ArrayList<>();
			for (Chemin chemin : chemins) {
				if (chemin.distance(cible) < distanceMin) {
					distanceMin = chemin.distance(cible);
				}
				chemin.setNbrMinutes(chemin.getNbrMinutes() + 1);
				if (chemin.getAttenteChangementEquipement() > 0) {
					chemin.setAttenteChangementEquipement(chemin.getAttenteChangementEquipement() - 1);
					newChemins.add(chemin);
				} else if (chemin.getRegionAttente() != null) {
					if (!contient(regionsDejaVues, chemin.getRegionAttente(), chemin.getEquipement(),
							chemin.getNbrMinutes())) {
						Chemin newChemin = new Chemin(chemin);
						newChemin.getChemin().add(chemin.getRegionAttente());
						regionsDejaVues.add(new RegionEquipementWrapper(chemin.getRegionAttente(),
								chemin.getEquipement(), chemin.getNbrMinutes()));
						newChemins.add(newChemin);
						if (chemin.getRegionAttente() == cible) {
							meilleurChemin = newChemin;
							break;
						}
					}
					chemin.setRegionAttente(null);
				} else {
					for (Region regionAdjacente : chemin.getChemin().get(chemin.getChemin().size() - 1)
							.getRegionsAdjacentes()) {
						boolean adj = false;
						for (int i = 0; i < chemin.getChemin().size() - 1; i++) {
							if (chemin.getChemin().get(i).getRegionsAdjacentes().contains(regionAdjacente)) {
								adj = true;
								break;
							}
						}
						if (!adj && !contient(regionsDejaVues, regionAdjacente, chemin.getEquipement(),
								chemin.getNbrMinutes()) && chemin.distance(cible) < distanceMin + 30) {
							if (regionAdjacente == cible) {
								if (chemin.getEquipement() == Equipement.TORCHE) {
									Chemin newChemin = new Chemin(chemin);
									newChemin.getChemin().add(regionAdjacente);
									regionsDejaVues.add(new RegionEquipementWrapper(regionAdjacente,
											chemin.getEquipement(), chemin.getNbrMinutes()));
									newChemins.add(newChemin);
									meilleurChemin = newChemin;
									break;
								} else {
									Chemin newChemin = new Chemin(chemin, Equipement.TORCHE);
									newChemin.setRegionAttente(regionAdjacente);
									newChemin.setAttenteChangementEquipement(6);
									newChemins.add(newChemin);
								}
							} else if (chemin.getEquipement().getRisquesAcceptes()
									.contains(regionAdjacente.getNiveauRisque())) {
								Chemin newChemin = new Chemin(chemin);
								newChemin.getChemin().add(regionAdjacente);
								regionsDejaVues.add(new RegionEquipementWrapper(regionAdjacente, chemin.getEquipement(),
										chemin.getNbrMinutes()));
								newChemins.add(newChemin);
								if (regionAdjacente == cible) {
									meilleurChemin = newChemin;
									break;
								}
							} else {
								for (Equipement e : Equipement.values()) {
									if (e != chemin.getEquipement()) {
										Chemin newChemin = new Chemin(chemin, e);
										newChemin.setRegionAttente(regionAdjacente);
										newChemin.setAttenteChangementEquipement(6);
										newChemins.add(newChemin);
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println(meilleurChemin.getNbrMinutes());

	}

	public static boolean contient(List<RegionEquipementWrapper> regionsDejaVues, Region region, Equipement equipement,
			int minute) {
		for (RegionEquipementWrapper regionEquipementWrapper : regionsDejaVues) {
			if (regionEquipementWrapper.getRegion() == region) {
				return equipement == regionEquipementWrapper.getEquipement()
						|| minute > regionEquipementWrapper.getMinute() + 6;
			}
		}
		return false;
	}

}
