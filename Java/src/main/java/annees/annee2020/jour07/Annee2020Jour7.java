package annees.annee2020.jour07;

import java.util.regex.Pattern;

import commun.structure.ExerciceInputToObject;
import commun.util.FileUtils;

public abstract class Annee2020Jour7 extends ExerciceInputToObject<Sac> {

	protected Pattern pattern = Pattern.compile("(.*) bags contain (.*).");

	@Override
	protected void init() {
	}

	@Override
	protected Sac ligneToObject(String ligne) {
		var blocs = FileUtils.trouverPattern(ligne, pattern, 2);
		Sac sac = new Sac();
		sac.setType(blocs[0]);
		sac.setConteneur(blocs[1]);
		return sac;
	}

}
