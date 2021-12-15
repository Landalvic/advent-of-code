package annees.annee2020.jour17;

import java.util.HashSet;
import java.util.Set;

import commun.MapModifiable;
import commun.Position;
import commun.structure.AdventOfCodeException;
import commun.structure.ExerciceInputToMap;

public abstract class Annee2020Jour17 extends ExerciceInputToMap<Cube> {

	protected int dimension;

	public Annee2020Jour17(int exercice) {
		super(2020, 17, exercice);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var map = inputToMap(input);
		for (int i = 0; i < 6; i++) {
			Set<Cube> cubesAdj = new HashSet<>();
			map.listCopyAllCase().stream().forEach(cube -> gererSiege(map, cube, cubesAdj, true));
			cubesAdj.stream().forEach(cube -> gererSiege(map, cube, null, false));
			map.listeAllCase().stream().forEach(cube -> cube.setActif(cube.getFutureActif()));
			map.removeIf(c -> !c.isActif());
		}
		return String.valueOf(map.listeAllCase().stream().filter(Cube::isActif).count());
	}

	protected void gererSiege(MapModifiable<Cube> map, Cube cube, Set<Cube> cubesAdj, boolean ajout) {
		Set<Cube> adj = ajout ? cube.getCasesAdjacentesDiagNDim(position -> {
			Cube c = new Cube(map, position, false);
			if (cubesAdj != null) {
				cubesAdj.add(c);
			}
			return c;
		}) : cube.getCasesAdjacentesDiagNDim();
		long occupe = adj.stream().filter(Cube::isActif).count();
		if (cube.isActif()) {
			cube.setFutureActif(occupe >= 2 && occupe <= 3);
		} else {
			cube.setFutureActif(occupe == 3);
		}
	}

	@Override
	protected Cube ligneToMap(MapModifiable<Cube> map, String charAt, int posY, int posX) {
		int[] pos = new int[dimension];
		pos[0] = posX;
		pos[1] = posY;
		switch (charAt) {
			case "#":
				return new Cube(map, new Position(pos), true);
			case ".":
				return new Cube(map, new Position(pos), false);
			default:
				return null;
		}
	}

}
