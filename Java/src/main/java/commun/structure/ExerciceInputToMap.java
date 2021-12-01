package commun.structure;

import java.util.List;

import commun.Case;
import commun.MapCases;
import commun.util.FileUtils;

public abstract class ExerciceInputToMap<T extends Case<T>> extends Exercice {

	protected ExerciceInputToMap(int annee, int jour, int numeroExercice) {
		super(annee, jour, numeroExercice);
	}

	protected MapCases<T> inputToMap(String input) throws AdventOfCodeException {
		List<String> lignes = FileUtils.listOfLines(input);
		MapCases<T> map = new MapCases<>();
		for (int i = 0; i < lignes.size(); i++) {
			String ligne = lignes.get(i);
			for (int j = 0; j < ligne.length(); j++) {
				String c = String.valueOf(ligne.charAt(j));
				map.addCase(ligneToMap(map, c, i, j));
			}
		}
		return map;
	}

	protected abstract T ligneToMap(MapCases<T> map, String charAt, int posY, int posX);

}
