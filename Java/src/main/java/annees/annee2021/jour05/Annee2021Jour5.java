package annees.annee2021.jour05;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import commun.Position;
import commun.Vecteur;
import commun.structure.ExerciceInputToObject;
import commun.util.TexteUtils;

public abstract class Annee2021Jour5 extends ExerciceInputToObject<Vecteur> {

	protected Annee2021Jour5(int exercice) {
		super(2021, 5, exercice);
	}

	@Override
	protected Vecteur ligneToObject(String ligne) {
		InfosVecteur infos = TexteUtils.transformerPattern(ligne, InfosVecteur.class);
		return new Vecteur(infos.getX1(), infos.getY1(), infos.getX2(), infos.getY2());
	}

	protected String commun(Stream<Vecteur> vecteurs) {
		Map<Position, Integer> positions = new HashMap<>();
		vecteurs.forEach(v -> {
			for (var position : v.pointsOnSegment()) {
				positions.put(position, positions.computeIfAbsent(position, p -> 0) + 1);
			}
		});
		return String.valueOf(positions.values().stream().filter(v -> v >= 2).count());
	}

}
