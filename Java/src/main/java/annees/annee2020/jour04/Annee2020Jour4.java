package annees.annee2020.jour04;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import commun.structure.ExerciceInputToObject;

public abstract class Annee2020Jour4 extends ExerciceInputToObject<Passeport> {

	protected Passeport passeport;
	protected Map<String, Pattern> infos;

	@Override
	protected void init() {
		passeport = new Passeport();
		infos = new HashMap<>();
	}

	@Override
	protected Passeport ligneToObject(String ligne) {
		if (ligne.trim().length() == 0) {
			var p = passeport;
			passeport = new Passeport();
			return p;
		} else {
			passeport.ajouterInfos(ligne);
			return null;
		}
	}

}
