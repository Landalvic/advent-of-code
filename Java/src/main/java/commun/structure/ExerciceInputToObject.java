package commun.structure;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import commun.util.FileUtils;

public abstract class ExerciceInputToObject<T> extends Exercice {

	protected ExerciceInputToObject(int annee, int jour, int exercice) {
		super(annee, jour, exercice);
	}

	protected Stream<T> inputToStreamObject(String input) throws AdventOfCodeException {
		Stream<String> liste = FileUtils.streamOfLines(input);
		return liste.map(this::ligneToObject);
	}

	protected Stream<T> inputToStreamObjectNotNull(String input) throws AdventOfCodeException {
		return inputToStreamObject(input).filter(Objects::nonNull);
	}

	protected List<T> inputToListObject(String input) throws AdventOfCodeException {
		return inputToStreamObject(input).toList();
	}

	protected List<T> inputToListObjectNotNull(String input) throws AdventOfCodeException {
		return inputToStreamObjectNotNull(input).toList();
	}

	protected Set<T> inputToSetObject(String input) throws AdventOfCodeException {
		return inputToStreamObject(input).collect(Collectors.toSet());
	}

	protected Set<T> inputToSetObjectNotNull(String input) throws AdventOfCodeException {
		return inputToStreamObjectNotNull(input).collect(Collectors.toSet());
	}

	protected abstract T ligneToObject(String ligne);

}
