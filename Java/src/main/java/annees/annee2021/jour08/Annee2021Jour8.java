package annees.annee2021.jour08;

import commun.structure.AdventOfCodeException;
import commun.structure.ExerciceInputToObject;

public abstract class Annee2021Jour8 extends ExerciceInputToObject<CodeDigits> {

	protected Annee2021Jour8(int exercice) {
		super(2021, 8, exercice);
	}

	@Override
	protected CodeDigits ligneToObject(String ligne) {
		CodeDigits code = new CodeDigits();
		var blocs = ligne.split(" \\| ");
		code.setDigits(blocs[0].split(" "));
		code.setOutput(blocs[1].split(" "));
		return code;
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = inputToStreamObject(input);
		return String.valueOf(stream.mapToInt(this::transformCode).sum());
	}

	protected abstract int transformCode(CodeDigits code);

}
