package commun.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import commun.util.FileUtils;

public abstract class ExerciceInputBlocToObject<T> extends Exercice {

	protected ExerciceInputBlocToObject(int annee, int jour, int exercice) {
		super(annee, jour, exercice);
	}

	protected List<T> inputToListObject(String input) throws AdventOfCodeException {
		return inputToListObject(input, 0);
	}

	protected List<T> inputToListObjectNotNull(String input) throws AdventOfCodeException {
		return inputToListObjectNotNull(input, 0);
	}

	protected Set<T> inputToSetObject(String input) throws AdventOfCodeException {
		return inputToSetObject(input, 0);
	}

	protected Set<T> inputToSetObjectNotNull(String input) throws AdventOfCodeException {
		return inputToSetObjectNotNull(input, 0);
	}

	protected List<T> inputToListObject(String input, int firstLine) throws AdventOfCodeException {
		List<String> liste = FileUtils.listOfLines(input);
		List<T> listeObjects = new ArrayList<>();
		List<String> bloc = new ArrayList<>();
		for (int i = firstLine; i < liste.size(); i += 1) {
			if (StringUtils.isNotEmpty(liste.get(i))) {
				bloc.add(liste.get(i));
			} else {
				listeObjects.add(blocToObject(bloc));
				bloc.clear();
			}
		}
		if (!bloc.isEmpty()) {
			listeObjects.add(blocToObject(bloc));
		}
		return listeObjects;
	}

	protected List<T> inputToListObjectNotNull(String input, int firstLine) throws AdventOfCodeException {
		return inputToListObject(input, firstLine).stream().filter(Objects::nonNull).toList();
	}

	protected Set<T> inputToSetObject(String input, int firstLine) throws AdventOfCodeException {
		return inputToListObject(input, firstLine).stream().collect(Collectors.toSet());
	}

	protected Set<T> inputToSetObjectNotNull(String input, int firstLine) throws AdventOfCodeException {
		return inputToListObjectNotNull(input, firstLine).stream().collect(Collectors.toSet());
	}

	protected List<T> inputToListObject(String input, int firstLine, int longueurBloc) throws AdventOfCodeException {
		List<String> liste = FileUtils.listOfLines(input);
		List<T> listeObjects = new ArrayList<>();
		for (int i = firstLine; i < liste.size(); i += longueurBloc + 1) {
			if (liste.size() > i + longueurBloc - 1) {
				listeObjects.add(blocToObject(liste.subList(i, i + longueurBloc)));
			}
		}
		return listeObjects;
	}

	protected List<T> inputToListObjectNotNull(String input, int firstLine, int longueurBloc) throws AdventOfCodeException {
		return inputToListObject(input, firstLine, longueurBloc).stream().filter(Objects::nonNull).toList();
	}

	protected Set<T> inputToSetObject(String input, int firstLine, int longueurBloc) throws AdventOfCodeException {
		return inputToListObject(input, firstLine, longueurBloc).stream().collect(Collectors.toSet());
	}

	protected Set<T> inputToSetObjectNotNull(String input, int firstLine, int longueurBloc) throws AdventOfCodeException {
		return inputToListObjectNotNull(input, firstLine, longueurBloc).stream().collect(Collectors.toSet());
	}

	protected abstract T blocToObject(List<String> blocs);

}
