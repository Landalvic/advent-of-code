package commun.structure;

import java.util.List;

import commun.Case;
import commun.InterfaceMap;
import commun.MapModifiable;
import commun.MapUnmodifiable;
import commun.Position;
import commun.SimpleCase;
import commun.util.FileUtils;

public abstract class ExerciceInputToMap<T extends Case<T>> extends Exercice {

	protected ExerciceInputToMap(int annee, int jour, int numeroExercice) {
		super(annee, jour, numeroExercice);
	}

	protected InterfaceMap<T> inputToMap(String input, boolean fixedButOptimized) throws AdventOfCodeException {
		List<String> lignes = FileUtils.listOfLines(input);
		InterfaceMap<T> map;
		if (fixedButOptimized) {
			map = new MapUnmodifiable<>(new SimpleCase[lignes.get(0).length()][lignes.size()]);
		} else {
			map = new MapModifiable<>();
		}
		for (int i = 0; i < lignes.size(); i++) {
			String ligne = lignes.get(i);
			for (int j = 0; j < ligne.length(); j++) {
				String c = String.valueOf(ligne.charAt(j));
				map.addCase(ligneToMap(map, c, new Position(j, i)));
			}
		}
		return map;
	}

	protected abstract T ligneToMap(InterfaceMap<T> map, String charAt, Position position);

}
