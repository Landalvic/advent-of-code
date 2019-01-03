package jours.jour23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour23Exercice2 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour23/data.txt");
		Pattern positionPattern = Pattern.compile("pos=<(.*)>.*");
		Pattern rayonPattern = Pattern.compile(".*>, r=(.*)");
		List<Nanobot> nanobots = new ArrayList<>(liste.size());
		Position positionMin = new Position(999999999, 999999999, 999999999);
		Position positionMax = new Position(-999999999, -999999999, -999999999);
		long puissanceMin = 999999999;
		for (String string : liste) {
			String[] position = FileUtils.trouverPattern(string, positionPattern).split(",");
			long rayon = FileUtils.trouverPatternInt(string, rayonPattern);
			Nanobot nanobot = new Nanobot(Long.valueOf(position[0]), Long.valueOf(position[1]),
					Long.valueOf(position[2]), rayon);
			if (positionMin.getPositionX() > nanobot.getPosition().getPositionX()) {
				positionMin.setPositionX(nanobot.getPosition().getPositionX());
			}
			if (positionMin.getPositionY() > nanobot.getPosition().getPositionY()) {
				positionMin.setPositionY(nanobot.getPosition().getPositionY());
			}
			if (positionMin.getPositionZ() > nanobot.getPosition().getPositionZ()) {
				positionMin.setPositionZ(nanobot.getPosition().getPositionZ());
			}
			if (positionMax.getPositionX() < nanobot.getPosition().getPositionX()) {
				positionMax.setPositionX(nanobot.getPosition().getPositionX());
			}
			if (positionMax.getPositionY() < nanobot.getPosition().getPositionY()) {
				positionMax.setPositionY(nanobot.getPosition().getPositionY());
			}
			if (positionMax.getPositionZ() < nanobot.getPosition().getPositionZ()) {
				positionMax.setPositionZ(nanobot.getPosition().getPositionZ());
			}
			if (puissanceMin > nanobot.getPuissanceSignal()) {
				puissanceMin = nanobot.getPuissanceSignal();
			}
			nanobots.add(nanobot);
		}

		List<PositionNbrWrapper> meilleurePosition = calcul(positionMin, positionMax, nanobots, puissanceMin);

		long maxNbr = 0;
		for (PositionNbrWrapper positionNbrWrapper : meilleurePosition) {
			System.out.println(positionNbrWrapper.getPosition() + " : " + positionNbrWrapper.getNbr());
			if (positionNbrWrapper.getNbr() > maxNbr) {
				maxNbr = positionNbrWrapper.getNbr();
			}
		}

		long distanceMin = 999999999999999999L;
		Position centre = new Position(0, 0, 0);
		puissanceMin = 1;
		Position best = meilleurePosition.get(meilleurePosition.size() - 1).getPosition();
		long ecart = 100;
		long nbrNanobotsMax = 936;
		for (long i = best.getPositionX() - 100; i < best.getPositionX() + ecart; i += puissanceMin) {
			for (long j = best.getPositionY() - 100; j < best.getPositionY() + ecart; j += puissanceMin) {
				for (long k = best.getPositionZ() - 100; k < best.getPositionZ() + ecart; k += puissanceMin) {
					Position p = new Position(i, j, k);
					long nbrNanobotsAPortee = 0;
					for (Nanobot nanobot : nanobots) {
						if (nanobot.aPortee(p)) {
							nbrNanobotsAPortee++;
						}
					}
					if (nbrNanobotsMax <= nbrNanobotsAPortee) {
						if (nbrNanobotsAPortee >= nbrNanobotsMax) {
							long distance = p.distance(centre);
							System.out.println("oui" + nbrNanobotsAPortee);
							if (distance < distanceMin) {
								distanceMin = distance;
							}
						}
					}
				}
			}
		}

		System.out.println(distanceMin);

	}

	private static List<PositionNbrWrapper> calcul(Position positionMin, Position positionMax, List<Nanobot> nanobots,
			long puissanceMin) {
		long nbrNanobotsMax = 0;
		List<PositionNbrWrapper> meilleursPoints = new ArrayList<>();
		for (long i = positionMin.getPositionX(); i < positionMax.getPositionX(); i += puissanceMin) {
			for (long j = positionMin.getPositionY(); j < positionMax.getPositionY(); j += puissanceMin) {
				for (long k = positionMin.getPositionZ(); k < positionMax.getPositionZ(); k += puissanceMin) {
					Position p = new Position(i, j, k);
					long nbrNanobotsAPortee = 0;
					for (Nanobot nanobot : nanobots) {
						if (nanobot.aPortee(p)) {
							nbrNanobotsAPortee++;
						}
					}
					meilleursPoints.add(new PositionNbrWrapper(p, nbrNanobotsAPortee));
					if (nbrNanobotsMax < nbrNanobotsAPortee) {
						nbrNanobotsMax = nbrNanobotsAPortee;
					}
				}
			}
		}

		for (int i = 0; i < meilleursPoints.size(); i++) {
			if (meilleursPoints.get(i).getNbr() < nbrNanobotsMax) {
				meilleursPoints.remove(i);
				i--;
			}
		}

		long newPuissanceMin = 0;
		if (puissanceMin == 1) {
			return meilleursPoints;
		} else if (puissanceMin <= 20) {
			newPuissanceMin = 1;
		} else {
			newPuissanceMin = puissanceMin / 10;
		}
		if (meilleursPoints.size() > 1) {
			meilleursPoints = Arrays.asList(meilleursPoints.get(0), meilleursPoints.get(meilleursPoints.size() - 1));
		}

		List<PositionNbrWrapper> meilleursRetour = new ArrayList<>();
		for (int i = 0; i < meilleursPoints.size(); i++) {
			Position enCours = meilleursPoints.get(i).getPosition();
			positionMin = new Position(enCours.getPositionX() - puissanceMin, enCours.getPositionY() - puissanceMin,
					enCours.getPositionZ() - puissanceMin);
			positionMax = new Position(enCours.getPositionX() + puissanceMin, enCours.getPositionY() + puissanceMin,
					enCours.getPositionZ() + puissanceMin);
			meilleursRetour.addAll(calcul(positionMin, positionMax, nanobots, newPuissanceMin));
		}
		return meilleursRetour;
	}

}
